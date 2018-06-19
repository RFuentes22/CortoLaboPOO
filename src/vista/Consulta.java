/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import dao.FiltroDao;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import modelo.Filtro;

/**
 *
 * @author LN710Q
 */
public class Consulta extends JFrame {

    public JLabel lblNinscripcion, lblNombre, lblPropietario, lblEdad, lblRaza, lblEstado;
    public JTextField codigo, descripcion, stock, nombre, propietario, edad;
   
    public JComboBox raza;
    ButtonGroup existencia = new ButtonGroup();
    public JRadioButton no;
    public JRadioButton si;
    public JTable resultados;
    public JPanel table;
    public JButton buscar, eliminar, insertar, limpiar, actualizar;
    private static final int ANCHOC = 130, ALTOC = 30;
    DefaultTableModel tm;

    public Consulta() {
        super("Inscripciones");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);
        agregarLabels();
        formulario();
        llenarTabla();
        Container container = getContentPane();
        container.add(lblNinscripcion);
        container.add(lblNombre);
       
        container.add(lblPropietario);
        container.add(lblEdad);
        container.add(lblRaza);
        container.add(lblEstado);
        //container.add(nombre);
        container.add(codigo);
        //   container.add(marca);
        container.add(nombre);
        container.add(edad);
        container.add(raza);
        container.add(propietario);
        container.add(stock);
        container.add(si);
        container.add(no);
        container.add(buscar);
        container.add(insertar);
        container.add(actualizar);
        container.add(eliminar);
        container.add(limpiar);
        container.add(table);
        setSize(600, 600);
        eventos();
    }

    public final void agregarLabels() {
        lblNinscripcion = new JLabel("N°Inscripcion");
        lblEdad = new JLabel("Edad");
        lblEstado = new JLabel("Estado");

        lblRaza = new JLabel("Raza");
        lblNombre = new JLabel("Nombre");
        lblPropietario = new JLabel("Propietario");
   
        lblNinscripcion.setBounds(10, 10, ANCHOC, ALTOC);
        lblNombre.setBounds(10, 60, ANCHOC, ALTOC);
        lblEstado.setBounds(10, 165, ANCHOC, ALTOC);
        lblPropietario.setBounds(300, 60, ANCHOC, ALTOC);
        lblRaza.setBounds(10, 135, ANCHOC, ALTOC);
        lblEdad.setBounds(10, 100, ANCHOC, ALTOC);
        //  lblStock.setBounds(10, 100, ANCHOC, ALTOC);
        //  lblExistencia.setBounds(10, 140, ANCHOC, ALTOC);
    }

    public final void formulario() {
        codigo = new JTextField();
        //marca=new JComboBox();
        nombre = new JTextField();

        raza = new JComboBox();
        propietario = new JTextField();
        edad = new JTextField();
        stock = new JTextField();
        si = new JRadioButton("si", true);
        no = new JRadioButton("no");
        resultados = new JTable();
        buscar = new JButton("Buscar");
        insertar = new JButton("Insertar");
        eliminar = new JButton("Eliminar");
        actualizar = new JButton("Actualizar");
        limpiar = new JButton("Limpiar");
        table = new JPanel();
        raza.addItem("Pitbull");
        raza.addItem("Pastor Aleman");
        raza.addItem("Gran danes");
        raza.addItem("Dalmata");
        raza.addItem("Rottweiler");
        existencia = new ButtonGroup();
        existencia.add(si);
        existencia.add(no);
        codigo.setBounds(140, 10, ANCHOC, ALTOC);
        propietario.setBounds(380, 60, ANCHOC, ALTOC);
        edad.setBounds(90, 100, ANCHOC, ALTOC);
        raza.setBounds(90, 135, ANCHOC, ALTOC);
        // marca.setBounds(140, 60, ANCHOC, ALTOC);
        nombre.setBounds(140, 60, ANCHOC, ALTOC);
        si.setBounds(90, 165, 50, ALTOC);
        no.setBounds(137, 165, 50, ALTOC);
        buscar.setBounds(300, 10, ANCHOC, ALTOC);
        insertar.setBounds(10, 210, ANCHOC, ALTOC);
        actualizar.setBounds(150, 210, ANCHOC, ALTOC);
        eliminar.setBounds(300, 210, ANCHOC, ALTOC);
        limpiar.setBounds(450, 210, ANCHOC, ALTOC);
        resultados = new JTable();
        table.setBounds(10, 250, 500, 200);
        table.add(new JScrollPane(resultados));
    }

    public void llenarTabla() {
        tm = new DefaultTableModel() {
            public Class<?> getColumnClass(int column) {
                switch (column) {
                    case 0:
                        return String.class;
                    case 1:
                        return String.class;
                    case 2:
                        return String.class;
                    default:
                        return Boolean.class;
                }
            }
        };
        tm.addColumn("N°inscripcion");
        tm.addColumn("Nombre");
        tm.addColumn("Propietario");
        tm.addColumn("Raza");
        tm.addColumn("Estado");

        FiltroDao fd = new FiltroDao();
        ArrayList<Filtro> filtros = fd.readAll();
        for (Filtro fi : filtros) {
            tm.addRow(new Object[]{fi.getNombre(), fi.getPropietario(), fi.getRaza(), fi.isEstado()});
        }
        resultados.setModel(tm);
    }

    public void eventos() {
        insertar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                FiltroDao fd = new FiltroDao();
                Filtro f = new Filtro(codigo.getText(),nombre.getText(), true);
                if (no.isSelected()) {
                    f.setEstado(false);
                }
                if (fd.create(f)) {
                    JOptionPane.showMessageDialog(null, "filtro registrado con exito");
                    limpiarCampos();
                    llenarTabla();
                } else {
                    JOptionPane.showMessageDialog(null, "Ocurrio un problema al momento de crear el filtro");
                }
            }
        });
        actualizar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                FiltroDao fd = new FiltroDao();
                Filtro f = new Filtro(codigo.getText(),nombre.getText(), true);
                if (no.isSelected()) {
                    f.setEstado(false);
                }
                if (fd.update(f)) {
                    JOptionPane.showMessageDialog(null, "filtro modificado con exito");
                    limpiarCampos();
                    llenarTabla();
                } else {
                    JOptionPane.showMessageDialog(null, "Ocurrio un problema al momento de modificar el filtro");
                }
            }
        });

        eliminar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                FiltroDao fd = new FiltroDao();
                if (fd.delete(codigo.getText())) {
                    JOptionPane.showMessageDialog(null, "Filtro eliminado con exito");
                    limpiarCampos();
                    llenarTabla();
                } else {
                    JOptionPane.showMessageDialog(null, "Ocurrio un problema al momento de eliminar el filtro");
                }
            }
        });
        buscar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                FiltroDao fd = new FiltroDao();
                Filtro f = fd.read(codigo.getText());
                if (f == null) {
                    JOptionPane.showMessageDialog(null, "El filtro buscado no se ha encontrado");
                } else {
                    codigo.setText(f.getNombre());
                    // marca.setSelectedItem(f.getMarca());
                   // raza.setText(f.getRaza());
                    if (f.getExixtencia()) {
                        si.setSelected(true);
                    } else {
                        no.setSelected(true);
                    }
                }

            }
        });
        limpiar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                limpiarCampos();
            }
        });

    }

    public void limpiarCampos() {
        codigo.setText("");
        // marca.setSelectedItem("FRAM");
        stock.setText("");
    }

    public static void main(String[] args) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Consulta().setVisible(true);
            }
        });
    }
}

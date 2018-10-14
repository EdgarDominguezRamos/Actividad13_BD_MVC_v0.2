/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import models.ModelAgenda;
import views.ViewAgenda;

/**
 *
 * @author Zeo
 */
public class ControllerAgenda {

    ModelAgenda modelAgenda;
    ViewAgenda viewAgenda;

    /**
     * Objeto de tipo ActionListener para atrapar los eventos actionPerformed y
     * llamar a los metodos para ver los registros almacenados en la bd.
     */
    ActionListener actionListener = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == viewAgenda.jbtn_primero) {
                jbtn_primero_actionPerformed();
            } else if (e.getSource() == viewAgenda.jbtn_anterior) {
                jbtn_anterior_actionPerformed();
            } else if (e.getSource() == viewAgenda.jbtn_siguiente) {
                jbtn_siguiente_actionPerformed();
            } else if (e.getSource() == viewAgenda.jbtn_ultimo) {
                jbtn_ultimo_actionPerformed();
            }else if (e.getSource() == viewAgenda.jb_nuevo) {
                jbtn_nuevo_actionPerformed();
                limpiar();
            }else if (e.getSource() == viewAgenda.jb_guardar) {
                jbtn_guardar_actionPerformaed();
                jbtn_primero_actionPerformed();
            }else if (e.getSource() == viewAgenda.jb_modificar) {
                jbtn_modificar_actionPerformed();
            }else if (e.getSource() == viewAgenda.jb_eliminar) {
                jbtn_eliminar_actionPerformed();
                jbtn_primero_actionPerformed();
            }else if (e.getSource() == viewAgenda.jb_cancelarN) {
                cancelarNuevo();
                jbtn_primero_actionPerformed();
            }else if (e.getSource() == viewAgenda.jb_cancelarM) {
                cancelarNuevo();
                viewAgenda.jb_cancelarM.setVisible(false);
                viewAgenda.jb_guardarC.setVisible(false);
                jbtn_primero_actionPerformed();
            }else if (e.getSource() == viewAgenda.jb_guardarC) {
                guardarCambios();
                jbtn_primero_actionPerformed();
            }
        }

    };

    /**
     * Constructor de Controlador para unir el ModelAgenda y ViewAgenda
     *
     * @param modelAgenda objeto de tipo ModelAgenda
     * @param viewAgenda objeto de tipo ViewAgenda
     */
    public ControllerAgenda(ModelAgenda modelAgenda, ViewAgenda viewAgenda) {
        this.modelAgenda = modelAgenda;
        this.viewAgenda = viewAgenda;
        initComponents();
        setActionListener();
        initDB();
    }

    /**
     * Método que llama al método conectarBD del modelo y muestra el nombre y
     * email del primer registro en las cajas de texto de ViewAgenda.
     */
    public void initDB(){
        modelAgenda.conectarDB();
        viewAgenda.jtf_nombre.setText(modelAgenda.getNombre());
        viewAgenda.jtf_email.setText(modelAgenda.getEmail());
    }
    /**
     * Metodo para inicializar la ViewAgenda
     */
    public void initComponents() {
        viewAgenda.setLocationRelativeTo(null);
        viewAgenda.setTitle("Agenda MVC");
        viewAgenda.setVisible(true);
        viewAgenda.jb_guardar.setVisible(false);
        viewAgenda.jb_guardarC.setVisible(false);
        viewAgenda.jb_cancelarN.setVisible(false);
        viewAgenda.jb_cancelarM.setVisible(false); 
    }

    /**
     * Método para agregar el actionListener a cada boton de la vista
     */
    public void setActionListener() {
        viewAgenda.jbtn_primero.addActionListener(actionListener);
        viewAgenda.jbtn_anterior.addActionListener(actionListener);
        viewAgenda.jbtn_siguiente.addActionListener(actionListener);
        viewAgenda.jbtn_ultimo.addActionListener(actionListener);
        viewAgenda.jb_nuevo.addActionListener(actionListener);
        viewAgenda.jb_guardar.addActionListener(actionListener);
        viewAgenda.jb_modificar.addActionListener(actionListener);
        viewAgenda.jb_eliminar.addActionListener(actionListener);
        viewAgenda.jb_cancelarN.addActionListener(actionListener);
        viewAgenda.jb_cancelarM.addActionListener(actionListener);
        viewAgenda.jb_guardarC.addActionListener(actionListener);
    }

    /**
     * Método para ver el primer registro de la tabla contactos
     */
    private void jbtn_primero_actionPerformed() {
        modelAgenda.moverPrimerRegistro();
        viewAgenda.jtf_nombre.setText(modelAgenda.getNombre());
        viewAgenda.jtf_email.setText(modelAgenda.getEmail());
        System.out.println("Action del boton jbtn_primero");
        //invocar al metodo moverPrimerRegistro
        //mostrar nombre en la vista
        //mostar email en la vista
    }

    /**
     * Método para ver el registro anterior de la tabla contactos
     */
    private void jbtn_anterior_actionPerformed() {
        modelAgenda.moverAnteriorRegistro();
        viewAgenda.jtf_nombre.setText(modelAgenda.getNombre());
        viewAgenda.jtf_email.setText(modelAgenda.getEmail());
        System.out.println("Action del boton jbtn_anterior");
        //invocar al metodo moverAnteriorRegistro
        //mostrar nombre en la vista
        //mostar email en la vista
    }

    /**
     * Método para ver el último registro de la tabla contactos
     */
    private void jbtn_ultimo_actionPerformed() {
        modelAgenda.moverUltimoRegistro();
        viewAgenda.jtf_nombre.setText(modelAgenda.getNombre());
        viewAgenda.jtf_email.setText(modelAgenda.getEmail());
        System.out.println("Action del boton jbtn_ultimo");
        //invocar al metodo moverUltimoRegistro
        //mostrar nombre en la vista
        //mostar email en la vista
    }

    /**
     * Método para ver el siguiente registro de la tabla contactos
     */
    private void jbtn_siguiente_actionPerformed() {
        modelAgenda.moverSiguienteRegistro();
        viewAgenda.jtf_nombre.setText(modelAgenda.getNombre());
        viewAgenda.jtf_email.setText(modelAgenda.getEmail());
        System.out.println("Action del boton jbtn_siguiente");
        //invocar al metodo moverSiguienteRegistro
        //mostrar nombre en la vista
        //mostar email en la vista
    }
    private void jbtn_nuevo_actionPerformed(){
        viewAgenda.jb_guardar.setVisible(true);
        viewAgenda.jb_cancelarN.setVisible(true);
        viewAgenda.jtf_nombre.setEditable(true);
        viewAgenda.jtf_email.setEditable(true);
        viewAgenda.jpnl_navegacion.setVisible(false);
        viewAgenda.jb_modificar.setVisible(false);
        viewAgenda.jb_eliminar.setVisible(false);
        viewAgenda.jb_nuevo.setVisible(false);
        viewAgenda.jb_cancelarM.setVisible(false);
        viewAgenda.jb_guardarC.setVisible(false);
    }
    public void limpiar(){
        viewAgenda.jtf_nombre.setText("");
        viewAgenda.jtf_email.setText("");
    }
    private void jbtn_guardar_actionPerformaed(){
        modelAgenda.setNombre(viewAgenda.jtf_nombre.getText());
        modelAgenda.setEmail(viewAgenda.jtf_email.getText()); 
        modelAgenda.guardarRegistro();
        cancelarNuevo();
    }
    private void jbtn_modificar_actionPerformed(){
        viewAgenda.jtf_nombre.setEditable(true);
        viewAgenda.jtf_email.setEditable(true);
        viewAgenda.jb_nuevo.setVisible(false);
        viewAgenda.jb_cancelarM.setVisible(true);
        viewAgenda.jpnl_navegacion.setVisible(false);
        viewAgenda.jb_guardarC.setVisible(true);
        viewAgenda.jb_eliminar.setVisible(false);
        viewAgenda.jb_modificar.setVisible(false);
    }
    private void guardarCambios(){
        modelAgenda.setNombre(viewAgenda.jtf_nombre.getText());
        modelAgenda.setEmail(viewAgenda.jtf_email.getText()); 
        modelAgenda.guardarCambios();
        modelAgenda.conectarDB();
        cancelarNuevo();
    }
    private void jbtn_eliminar_actionPerformed(){
        modelAgenda.setNombre(viewAgenda.jtf_nombre.getText());
        modelAgenda.setEmail(viewAgenda.jtf_email.getText()); 
        modelAgenda.borrarRegistro();
        modelAgenda.conectarDB();
        cancelarNuevo();
    }
    public void cancelarNuevo(){
        modelAgenda.conectarDB();
        viewAgenda.jb_cancelarN.setVisible(false);
        viewAgenda.jtf_nombre.setEditable(false);
        viewAgenda.jtf_email.setEditable(false);
        viewAgenda.jb_guardar.setVisible(false);
        viewAgenda.jpnl_navegacion.setVisible(true);
        viewAgenda.jb_modificar.setVisible(true);
        viewAgenda.jb_eliminar.setVisible(true);
        viewAgenda.jb_nuevo.setVisible(true);
    }
}

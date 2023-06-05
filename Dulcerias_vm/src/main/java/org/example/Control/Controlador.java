package org.example.Control;

import org.example.ConexionDulceria.TablaDulces;
import org.example.Vista.Vista;
import org.example.modelo.ModeloDulceria;

import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.net.MalformedURLException;

public class Controlador extends MouseAdapter {
    private Vista view;
    private ModeloDulceria modelo;

    public Controlador(Vista view) {
        this.view = view;
        modelo=new ModeloDulceria();
        this.view.getTblTabla().setModel(modelo);
        this.view.getBotonAgregar().addMouseListener(this);
        this.view.getTblTabla().addMouseListener(this);
        modelo=new ModeloDulceria();
        this.view.getTblTabla().setModel(modelo);
        this.view.getBotoncarga().addMouseListener(this);
        this.view.getBotonEliminarFila().addMouseListener(this);
        this.view.getBotonEliminarCasilla().addMouseListener(this);





    }

    //DETALLES DE LOS EVENTOS
    @Override
    public void mouseClicked(MouseEvent e) {

        //eventos de boton de carga de la base de datos
        if (e.getSource()==this.view.getBotoncarga()) {
            System.out.println("evento sobre boton carga");

            modelo.cargarDatos();
            this.view.getTblTabla().setModel(modelo);
            this.view.getTblTabla().updateUI();
        }


        //eventos del boton para agregar nuevos datos
        if (e.getSource()==this.view.getBotonAgregar()){
            System.out.println("Evento sobre el boton");
            TablaDulces dulceria=new TablaDulces();
            dulceria.setID(Integer.parseInt(this.view.getTxtID().getText()));
            dulceria.setNombreDulce(this.view.getTxtNombreDulce().getText());
            dulceria.setTipoDeDulce(this.view.getTxtTipoDulce().getText());
            dulceria.setCantidadGramos(Double.parseDouble(this.view.getTxtCantidadGramos().getText()));
            dulceria.setPrecioDulce(Double.parseDouble(this.view.getTxtprecioDulce().getText()));
            dulceria.setURL(this.view.getTxtfotoDulce().getText());
            if (modelo.agregarDulce(dulceria)) {
                //CUADRO DE DIALOGO DE INFORMACION
                JOptionPane.showMessageDialog(view,"Se agrego correctamente","aviso",JOptionPane.INFORMATION_MESSAGE);
                this.view.getTblTabla().updateUI();
            }else {
                //CUADRO DE DIALOGO DE ERROR
                JOptionPane.showMessageDialog(view,"No se pudo agregar a la base de datos, revise su conexion","Error al insertar",JOptionPane.ERROR_MESSAGE);
            }

            this.view.limpiar();
        }


        //evento para mostrar imagen tras dar click en tabla
        if (e.getSource()==view.getTblTabla()){
            System.out.println("Evento sobre la tabla");
            //selectedRow nos indica el renglon seleccionado
            int index=this.view.getTblTabla().getSelectedRow();
            TablaDulces tmp=modelo.getTablaDulcesAtindex(index);
            try {
                //cambiamos la info vacia de inicio de imagendulce
                this.view.getImagenDulce().setIcon(tmp.getImagen());
            }catch (MalformedURLException mfue){
                System.out.println(e.toString());
            }
        }

        //Eliminar una fila completa de la tabla
        if (e.getSource()==view.getBotonEliminarFila()){
            int index=this.view.getTblTabla().getSelectedRow();
            String id=String.valueOf(modelo.getTablaDulcesAtindex(index).getID());
            System.out.println("operacion en boton de eliminar fila");
            int respuesta=JOptionPane.showConfirmDialog(view,"Seguro que quieres eliminar la fila?",
                    "Confirmacion",JOptionPane.YES_NO_OPTION);

            if (respuesta==0){
                if (modelo.eliminarDatos(Integer.parseInt(id))) {
                    //CUADRO DE DIALOGO DE INFORMACION
                    JOptionPane.showMessageDialog(view,"Se elimino correctamente","aviso",JOptionPane.INFORMATION_MESSAGE);
                    modelo.cargarDatos();
                    this.view.getTblTabla().setModel(modelo);
                    this.view.getTblTabla().updateUI();
                }else {
                    //CUADRO DE DIALOGO DE ERROR
                    JOptionPane.showMessageDialog(view,"No se pudo eliminar a la base de datos, revise su conexion","Error al insertar",JOptionPane.ERROR_MESSAGE);
                }
            }
        }

        if (e.getSource()==view.getBotonEliminarCasilla()){
            Object obj=this.view.getCambio().getText();
            //indica fila seleccionada
            int index=this.view.getTblTabla().getSelectedRow();
            //al utilizar esa fila indicamos la id de esa fila
            int id=modelo.getTablaDulcesAtindex(index).getID();
            //indica columna seleccionada
            int columna=this.view.getTblTabla().getSelectedColumn();
            if (modelo.actualizarDato(obj,id,columna)){
                //CUADRO DE DIALOGO DE INFORMACION
                JOptionPane.showMessageDialog(view,"Se modifico correctamente","aviso",JOptionPane.INFORMATION_MESSAGE);
                this.view.limpiar();
                modelo.cargarDatos();
                this.view.getTblTabla().setModel(modelo);
                this.view.getTblTabla().updateUI();

            }else {
                //CUADRO DE DIALOGO DE ERROR
                JOptionPane.showMessageDialog(view,"No se pudo eliminar a la base de datos, revise su conexion","Error al insertar",JOptionPane.ERROR_MESSAGE);
            }
        }
    }

}

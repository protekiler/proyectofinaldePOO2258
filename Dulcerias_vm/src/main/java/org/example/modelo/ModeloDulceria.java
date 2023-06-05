package org.example.modelo;

import org.example.ConexionDulceria.DulceriaDAO;
import org.example.ConexionDulceria.TablaDulces;

import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;
import java.sql.SQLDataException;
import java.sql.SQLException;
import java.util.ArrayList;

public class ModeloDulceria implements TableModel {


    //un array list de tipo datos que almacenara la informacion para las expecificaciones de la dulceria

    private ArrayList<TablaDulces> datos;
    private DulceriaDAO DulceDAO;
    public static final int COLS=6;
    public ModeloDulceria() {
        DulceDAO=new DulceriaDAO();
        datos=new ArrayList<>();
    }

    public ModeloDulceria(ArrayList<TablaDulces> datos) {
        this.datos = datos;
        DulceDAO=new DulceriaDAO();
    }


    //cantidad de filas de la tabla,sin embargo la tabla tendra diversas modificaciones entorno a el numero de datos

    @Override
    public int getRowCount() {
        return datos.size();
    }

    @Override
    public int getColumnCount() {
        return COLS;
    }
//colocar los datos de la primera fila y las distintas columnas, entorno al valor de entrada de cada una;

    @Override
    public String getColumnName(int columnIndex) {
        String columName="";
        switch (columnIndex){
            case 0:
                columName="ID";
                break;
            case 1:
                columName="Nombre del Dulce";
                break;
            case 2:
                columName="Tipo de Dulce";
                break;
            case 3:
                columName="Cantidad en Gramos";
                break;
            case 4:
                columName="Precio del Dulce";
                break;
            case 5:
                columName="URL";
                break;
        }
        return columName;
    }
// aqui funciona de forma similar al anterior, pero nos pregunta que tipo de dato acepta

    @Override
    public Class<?> getColumnClass(int columnIndex) {
        switch (columnIndex){
            case 0:
                return Integer.class;
            case 1:
                return String.class;
            case 2:
                return String.class;
            case 3:
                return Double.class;
            case 4:
                return Double.class;
            case 5:
                return String.class;
        }
        return null;
    }
    //pregunta si alguna celda es de tipo editable
    //Esto lo veremos despues--------------------------------------------------------------------------------
    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return true;
    }
    //nos permite identifica que tipo de datos hay en esa localidad y mostrarlo en ventana
    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        //recordemos que "row" hace referencia a fila y "column" a columna
        TablaDulces tmp=datos.get(rowIndex);
        switch (columnIndex){
            case 0:
                return tmp.getID();
            case 1:
                return tmp.getNombreDulce();
            case 2:
                return tmp.getTipoDeDulce();
            case 3:
                return tmp.getCantidadGramos();
            case 4:
                return tmp.getPrecioDulce();
            case 5:
                return tmp.getURL();
        }
        return null;
    }

    @Override
    public void setValueAt(Object o, int rowIndex, int columnIndex) {
        switch (columnIndex){
            case 0:
                //datos.get(rowIndex).getID();
                break;
            case 1:
                datos.get(rowIndex).setNombreDulce((String)o);
                break;
            case 2:
                datos.get(rowIndex).setTipoDeDulce((String)o);
                break;
            case 3:
                datos.get(rowIndex).setCantidadGramos((Double)o );
                break;
            case 4:
                datos.get(rowIndex).setPrecioDulce((Double)o );
                break;
            case 5:
                datos.get(rowIndex).setURL((String)o);
                break;
            default:
                System.out.println("Nada modificado");
        }
    }

    @Override
    public void addTableModelListener(TableModelListener l) {

    }

    @Override
    public void removeTableModelListener(TableModelListener l) {

    }

    public Boolean agregarDulce(TablaDulces Dulce){
        boolean resultado=false;
        try {
            if (DulceDAO.insertar(Dulce)){
                datos.add(Dulce);
                resultado=true;
            }else{
                resultado=false;
            }
        }catch (SQLException SQLE){
            System.out.println(SQLE.getMessage());
        }return resultado;
    }
    public Boolean eliminarDatos(int id){
        boolean resultado=false;
        String numero=id+"";
        try {
            if (DulceDAO.delete(numero)){
                resultado=true;
            }else{
                resultado=false;
            }
        }catch (SQLException sqle){
            System.out.println(sqle.getMessage());

        }return resultado;
    }
    public Boolean actualizarDato(Object obj,int id, int columna){
        boolean resultado=false;

        try {
            if (DulceDAO.AgregarDato(obj,id,columna)){
                resultado=true;
            }else{
                resultado=false;
            }
        }catch (SQLException sqle){
            System.out.println(sqle.getMessage());

        }return resultado;
    }

    public TablaDulces getTablaDulcesAtindex(int idx){
        return datos.get(idx);

    }
    public void cargarDatos(){
        try {
            ArrayList<TablaDulces>DULCE=DulceDAO.obtenerTodo();
            System.out.println(DULCE);
            datos=DulceDAO.obtenerTodo();
        }catch (SQLException sqle){
            System.out.println(sqle.getMessage());
        }
    }



}

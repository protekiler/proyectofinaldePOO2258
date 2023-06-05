package org.example.ConexionDulceria;

import org.example.ConexionDulceria.InterfazDAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class DulceriaDAO implements InterfazDAO {
    public DulceriaDAO() {
    }

    @Override
    public boolean insertar(Object obj) throws SQLException {
        int rowCount = 0;
        String sqlInsert = "INSERT INTO Dulces(ID,NombreDulce,TipoDeDulce,CantidadGramos,PrecioDulce,URL) VALUES(?,?,?,?,?,?)";
        try {
            PreparedStatement pstm = ConexionSingleton.getInstance("Dulceria Vilarreal.db").getConnection().prepareStatement(sqlInsert);
            pstm.setInt(1, ((TablaDulces) obj).getID());
            pstm.setString(2, ((TablaDulces) obj).getNombreDulce());
            pstm.setString(3, ((TablaDulces) obj).getTipoDeDulce());
            pstm.setDouble(4, ((TablaDulces) obj).getCantidadGramos());
            pstm.setDouble(5, ((TablaDulces) obj).getPrecioDulce());
            pstm.setString(6,((TablaDulces)obj).getURL());
            rowCount = pstm.executeUpdate();
            System.out.println("se inserto " + rowCount + " registros");
        } catch (SQLException sqle) {
            System.out.println("error prepared statement" + sqle.getMessage());
        }
        return rowCount > 0;
    }

    @Override
    public boolean update(Object obj) throws SQLException {
        int rowCount=0;
        return rowCount > 0;
    }
    public boolean AgregarDato(Object obj, int id, int columna) throws SQLException {
        int rowCount = 0;
        String sqlDelete;
        PreparedStatement pstm= null;
        switch (columna){
            case 0:
                System.out.println("No se puede actualizar un id");
                break;
            case 1:
                sqlDelete = "UPDATE Dulces SET NombreDulce = ? WHERE id = ? ;";
                pstm = ConexionSingleton.getInstance("motosDB.db").getConnection().prepareStatement(sqlDelete);
                pstm.setString(1, (String)obj);
                pstm.setInt(2, id);
                rowCount = pstm.executeUpdate();
                break;
            case 2:
                sqlDelete = "UPDATE Dulces SET TipoDeDulce = ? WHERE id = ? ;";
                pstm = ConexionSingleton.getInstance("motosDB.db").getConnection().prepareStatement(sqlDelete);
                pstm.setString(1, (String)obj);
                pstm.setInt(2, id);
                rowCount = pstm.executeUpdate();
                break;
            case 3:
                sqlDelete = "UPDATE Dulces SET CantidadGramos = ? WHERE id = ? ;";
                pstm = ConexionSingleton.getInstance("motosDB.db").getConnection().prepareStatement(sqlDelete);
                pstm.setDouble(1, (Double)obj);
                pstm.setInt(2, id);
                rowCount = pstm.executeUpdate();
                break;
            case 4:
                sqlDelete = "UPDATE Dulces SET PrecioDulce = ? WHERE id = ? ;";
                pstm = ConexionSingleton.getInstance("motosDB.db").getConnection().prepareStatement(sqlDelete);
                pstm.setString(1, (String)obj);
                pstm.setInt(2, id);
                rowCount = pstm.executeUpdate();
                break;
            case 5:
                sqlDelete = "UPDATE Dulces SET URL = ? WHERE id = ? ;";
                pstm = ConexionSingleton.getInstance("motosDB.db").getConnection().prepareStatement(sqlDelete);
                pstm.setString(1, (String)obj);
                pstm.setInt(2, id);
                rowCount = pstm.executeUpdate();
                break;
        }
        return rowCount > 0;
    }

    @Override



    public boolean delete(String id) throws SQLException {
        String squlDelete = "DELETE FROM Dulces WHERE ID=?;";
        int rowCount = 0;
        PreparedStatement pstm = ConexionSingleton.getInstance("Dulceria Vilarreal.db").getConnection().prepareStatement(squlDelete);
            pstm.setString(1,id);
            rowCount = pstm.executeUpdate();

        return rowCount > 0;

    }

    @Override
    public ArrayList obtenerTodo() throws SQLException {
        String sql="SELECT* FROM Dulces";
        ArrayList<TablaDulces>resultado=new ArrayList<>();
        Statement stm=ConexionSingleton.getInstance("Dulceria Vilarreal.db").getConnection().createStatement();
        ResultSet rst=stm.executeQuery(sql);
        while (rst.next()){
            resultado.add(new TablaDulces(rst.getInt(1),rst.getString(2),rst.getString(3),rst.getDouble(4),rst.getDouble(5),rst.getString(6)));
        }
        return resultado;

    }

    @Override
    public Object buscarPorId(String id) throws SQLException {
        String sql = "SELECT *FROM Dulces WHERE id=?;";
        TablaDulces TablaDulces = null;

        PreparedStatement pstm = ConexionSingleton.getInstance("Dulceria Vilarreal.db").getConnection().prepareStatement(sql);
        pstm.setInt(1, Integer.parseInt(id));
        ResultSet rst = pstm.executeQuery();
        if (rst.next()) {
            TablaDulces = new TablaDulces(rst.getInt(1),rst.getString(2),rst.getString(3),rst.getDouble(4),rst.getDouble(5),rst.getString(6));

            return TablaDulces;
        }
        return null;
    }
}

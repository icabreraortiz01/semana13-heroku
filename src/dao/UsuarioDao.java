package dao;

import modelo.Usuario;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class UsuarioDao extends Conexion{
    public ArrayList<Usuario> listar() {
        ArrayList<Usuario> usuarios = new ArrayList();

        try (Connection connection = connectToDB()) {
            String query = "SELECT * FROM registro"; //sentencia
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                Usuario registrar = new Usuario(
                        //Integer.valueOf(rs.getString("regid")),
                        rs.getString("regnombres"),
                        rs.getString("regemail")
                );
                usuarios.add(registrar);
            }
        } catch (SQLException e) {
            System.out.println("" + e.getMessage());
            // TODO: handle exception
        }
        return usuarios;
    }
    //Guardar un nuevo usuario
    public void insertarRegistro(Usuario registro) {
        try (Connection connection = connectToDB()) {
            PreparedStatement ps = null;
            //Statement statement = connection.createStatement();
            String query = "insert into registro (regnombres, regemail) values (?,?)";
            ps = connection.prepareStatement(query);
            ps.setString(1, registro.getNombre());
            ps.setString(2, registro.getEmail());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    //Actualizar  un usuario
    public void actualizarRegistro(Usuario registro) {
        try (Connection connection = connectToDB()) {
            PreparedStatement ps = null;
            //Statement statement = connection.createStatement();
            String query = "update registro set regnombres = ?, regemail = ? where regid =?"; //ojo no olvidarsse del where
            ps = connection.prepareStatement(query);
            ps.setString(1, registro.getNombre());
            ps.setString(2, registro.getEmail());
            ps.setInt(3,  registro.getId());

            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("error:"+e.getMessage() );
            //estos errores guardar ennun archivo
        }
    }
    //Eliminar  un registro
    public void eliminarRegistro(int id) {
        try (Connection connection = connectToDB()) {
            PreparedStatement ps = null;
            //Statement statement = connection.createStatement();
            String query = "delete from registro where regid =? ";///ojo con el where
            ps = connection.prepareStatement(query);
            ps.setInt(1, id);

            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


}

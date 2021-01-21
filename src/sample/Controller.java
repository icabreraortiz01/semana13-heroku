package sample;

import dao.UsuarioDao;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import modelo.Usuario;
import javax.swing.*;

public class Controller {

    @FXML
    private TextField txtNombre;


    @FXML
    private TextField txtEmail;

    @FXML
    private void onCLICK(ActionEvent event) {
        boolean validar=false;

        try {
            while(validar==false){
                Usuario user = new Usuario(txtNombre.getText(),txtEmail.getText());
                String cadena= txtEmail.getText();
                for(int i=0;i<=cadena.length();i++){

                    if(cadena.charAt(i) == '@'){
                        validar=true;
                        UsuarioDao insertar = new UsuarioDao();
                        insertar.insertarRegistro(user);//lista.add(user1)
                        JOptionPane.showMessageDialog(null,"Se ha grabado correctamente");
                    }
                }
            }

        } catch (Exception ex) {
            if(validar==false){
                //System.out.println("ERROR: El correo no contiene el simbolo @");
                JOptionPane.showMessageDialog(null,"El correo no contiene el simbolo @");
            }
            System.out.println("" + ex.getMessage());
        }
    }

}

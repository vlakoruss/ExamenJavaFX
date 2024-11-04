package org.example.examenjavafx;

import com.sun.source.tree.TryTree;
import javafx.beans.Observable;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.ResourceBundle;

public class HelloController implements Initializable {


    @FXML
    private Spinner spVersion;
    @FXML
    private TableColumn colCorreo;
    @FXML
    private TableColumn colAdministrador;
    @FXML
    private Button btnEliminar;
    @FXML
    private TableColumn colPlataforma;
    @FXML
    private ChoiceBox chPlataforma;
    @FXML
    private CheckBox chAdministrador;
    @FXML
    private Button btnAñadir;
    @FXML
    private TableView<Usuario> tblGestorUsers;
    @FXML
    private TextField txtCorreo;

    private ObservableList<Usuario> usuarios;
    @FXML
    private TableColumn colFecha;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        usuarios = FXCollections.observableArrayList();
        tblGestorUsers.setItems(usuarios);
        colCorreo.setCellValueFactory(new PropertyValueFactory("correo"));
        colAdministrador.setCellValueFactory(new PropertyValueFactory("administrador"));
        colPlataforma.setCellValueFactory(new PropertyValueFactory("plataforma"));
        colFecha.setCellValueFactory(new PropertyValueFactory("fecha"));

        chPlataforma.setItems(FXCollections.observableArrayList("Windows", "Linux", "MacOS"));
        chPlataforma.setValue("Windows");

        spVersion.setValueFactory(new SpinnerValueFactory.IntegerSpinnerValueFactory(1, 5, 1));

    }

    @FXML
    public void seleccionar(Event event) {

        Usuario usuario = tblGestorUsers.getSelectionModel().getSelectedItem();

            if (usuario != null) {
                txtCorreo.setText(usuario.getCorreo());
                chAdministrador.setSelected(usuario.isAdministrador());
                chPlataforma.setValue(usuario.getPlataforma());

                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Detalles del Usuario");
                alert.setHeaderText(null);
                alert.setContentText("Correo: " + usuario.getCorreo() + "\nAdministrador: " + usuario.isAdministrador() + "\nPlataforma: " + usuario.getPlataforma()+ "\nFecha: " + new SimpleDateFormat("dd/MM/yyyy").format(usuario.getFecha()));
                alert.showAndWait();
            }


    }



    @FXML
    public void agregarUsuario(ActionEvent actionEvent) {

        try {
            Usuario usuario = new Usuario(txtCorreo.getText(), chAdministrador.isSelected(), chPlataforma.getValue().toString());

            if (!this.usuarios.contains(usuario)) {
                this.usuarios.add(usuario);
                this.tblGestorUsers.setItems(usuarios);


            } else {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error");
                alert.setHeaderText("Usuario ya existe");
                alert.setContentText("El usuario ya existe en la tabla");
                alert.showAndWait();
            }
        } catch (Exception e) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("Error al añadir el usuario");
            alert.setContentText(e.getMessage());
            alert.show();
        }
        txtCorreo.setText("");
        chAdministrador.setSelected(false);
        chPlataforma.setValue("Windows");
        spVersion.getValueFactory().setValue(1);

    }

    @FXML
    public void borrarTabla(ActionEvent actionEvent) {

        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Confirmar");
        alert.setHeaderText("Borrar tabla");
        alert.setContentText("¿Estas seguro de borrar la tabla?");
        alert.showAndWait();

        if(alert.getResult() == ButtonType.OK){
            usuarios.clear();
        }
    }





}
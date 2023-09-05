package sample;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class signUpController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField signUpAge;

    @FXML
    private TextField signUpBreed;

    @FXML
    private Button signUpButton;

    @FXML
    private TextField signUpDate;

    @FXML
    private TextField signUpDiet;

    @FXML
    private TextField signUpGender;

    @FXML
    private TextField signUpName;

    @FXML
    private TextField signUpPhoneNumber;

    @FXML
    private TextArea signUpReason;

    @FXML
    private TextField signUpSpecies;

    @FXML
    private TextField signUpVaccination;

    @FXML
    private TextField signUpWeight;

    @FXML
    void initialize() {
        DatabaseHandler dbHandler = new DatabaseHandler();
    signUpButton.setOnAction(event -> {
        dbHandler.signUpPatient(signUpName.getText(),signUpPhoneNumber.getText(),signUpDate.getText(),signUpSpecies.getText(),signUpBreed.getText(),signUpGender.getText(),signUpWeight.getText(),signUpAge.getText(),signUpDiet.getText(),signUpVaccination.getText(),signUpReason.getText());
    });

    }

}

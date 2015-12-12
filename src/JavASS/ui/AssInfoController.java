package JavASS.ui;

import JavASS.MainClass;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class AssInfoController {
	@FXML
	private TextField titre;
	@FXML
	private TextField originalScript;
	@FXML
	private TextField traduction;
	@FXML
	private TextField edition;
	@FXML
	private TextField time;
	@FXML
	private TextField synchro;
	@FXML
	private TextField updatedBy;
	@FXML
	private TextField details;
	@FXML
	private TextField resX;
	@FXML
	private TextField resY;

	@FXML
	private Button setResolution;
	@FXML
	private Button cancel;
	@FXML
	private Button ok;

	@FXML
	private ChoiceBox yCbCr;
	@SuppressWarnings("unchecked")
	@FXML
	private ChoiceBox wrapStyle = new ChoiceBox(FXCollections.observableArrayList(
		    "0 : Répartion intelligente, ligne du haut plus grande", "1 : Répartion en fin de ligne, césure sur \\N", "2 : Pas de répartition, césure uniquement sur \\n et \\N",
		    "3 : Répartition intelligente, ligne inférieure plus grande"));
	@FXML
	private CheckBox scale;

	private MainClass main;

	@FXML
	private void updateInfo()
	{
		if(!this.titre.getText().isEmpty())
		{
			this.main.getFile().getInfo().setTitre(this.titre.getText());
		}
		if(!this.originalScript.getText().isEmpty())
		{
			this.main.getFile().getInfo().setOriginalScript(this.originalScript.getText());
		}
		if(!this.traduction.getText().isEmpty())
		{
			this.main.getFile().getInfo().setTraduction(this.traduction.getText());
		}
		if(!this.edition.getText().isEmpty())
		{
			this.main.getFile().getInfo().setEdition(this.edition.getText());
		}
		if(!this.time.getText().isEmpty())
		{
			this.main.getFile().getInfo().setTiming(this.time.getText());
		}
		if(!this.synchro.getText().isEmpty())
		{
			this.main.getFile().getInfo().setSynch(this.synchro.getText());
		}
		if(!this.updatedBy.getText().isEmpty())
		{
			this.main.getFile().getInfo().setUpdatedBy(this.updatedBy.getText());
		}
		if(!this.details.getText().isEmpty())
		{
			this.main.getFile().getInfo().setUpdateDetails(this.details.getText());
		}
		if(!this.resX.getText().isEmpty())
		{
			this.main.getFile().getInfo().setResX(Integer.parseInt(this.resX.getText()));
		}
		if(!this.resY.getText().isEmpty())
		{
			this.main.getFile().getInfo().setResY(Integer.parseInt(this.resY.getText()));
		}

	}

	@FXML
	private void cancel()
	{
		Stage stage = (Stage) this.cancel.getScene().getWindow();
		stage.close();
	}

	@SuppressWarnings("unchecked")
	@FXML
	public void display()
	{
		this.titre.setText(this.main.getFile().getInfo().getTitre());
		this.originalScript.setText(this.main.getFile().getInfo().getOriginalScript());
		this.traduction.setText(this.main.getFile().getInfo().getTraduction());
		this.edition.setText(this.main.getFile().getInfo().getEdition());
		this.time.setText(this.main.getFile().getInfo().getTiming());
		this.synchro.setText(this.main.getFile().getInfo().getSynch());
		this.updatedBy.setText(this.main.getFile().getInfo().getUpdatedBy());
		this.details.setText(this.main.getFile().getInfo().getUpdateDetails());
		this.resX.setText(String.valueOf(this.main.getFile().getInfo().getResX()));
		this.resY.setText(String.valueOf(this.main.getFile().getInfo().getResY()));
		this.wrapStyle.getSelectionModel().select(this.main.getFile().getInfo().getWrapStyle());
		this.yCbCr.getSelectionModel().select(this.yCbCr.getItems().indexOf(this.main.getFile().getInfo().getYCbCr()));
		this.scale.setSelected(this.main.getFile().getInfo().getScale());
	}

	public void setMain(MainClass main)
	{
		this.main = main;
	}



}

package JavASS;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;


import java.io.IOException;

import JavASS.model.AssFile;
import JavASS.model.AssInfo;
import JavASS.model.SubtitleLine;
import JavASS.ui.AssInfoController;
import JavASS.ui.MenuController;
import JavASS.ui.SubtitleController;

public class MainClass extends Application {
	protected Stage mainStage;
	protected BorderPane menuUI;
	protected BorderPane subtitle;
	protected AnchorPane infoPane;
	protected AssFile file;
	protected ObservableList<SubtitleLine> ass = FXCollections.observableArrayList();
	protected AssInfo info;

	public MainClass()
	{
		this.file = new AssFile();
	}

	@Override
	public void start(Stage primaryStage) {
		this.mainStage=primaryStage;
		this.mainStage.setTitle("JavASS");
		this.mainStage.setFullScreen(true);

		initRootLayout();
		displaySubtitleUI();
	}

	public static void main(String[] args) {
		launch(args);
	}

	private void initRootLayout()
	{
		try
		{
			//On crée un objet pour charger le FXML MenuUI
			this.file.getLines().add(new SubtitleLine(true, 1, 1, "", "", "", "", "", 0, 0, 0, ""));
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(MainClass.class.getResource("ui/MenuUI.fxml"));

			//On charge la barre de menu
			menuUI = (BorderPane)loader.load();
			MenuController menuController =loader.getController();
			menuController.setMain(this);

			//On ajoute l'élément du décor à la scène
			Scene scene = new Scene(menuUI);
			mainStage.setScene(scene);
			mainStage.show();
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
	}

	private void displaySubtitleUI() {
        try {
            // Load person overview.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainClass.class.getResource("ui/subtitleUI.fxml"));
            subtitle = (BorderPane) loader.load();

            // Set person overview into the center of root layout.
            menuUI.setCenter(subtitle);
            SubtitleController subController =loader.getController();
            subController.setMainClass(this);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

	public void displayInfo()
	{

		try {
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(MainClass.class.getResource("ui/AssInfoUI.fxml"));
			infoPane =(AnchorPane) loader.load();
			AssInfoController infoctrl = loader.getController();
			infoctrl.setMain(this);


			Stage infoScene = new Stage();
			infoScene.setTitle("Informations du script");
			infoScene.initModality(Modality.WINDOW_MODAL);
			infoScene.initOwner(getStage());
			Scene scene = new Scene(infoPane);
			infoScene.setScene(scene);
			infoctrl.display();
			infoScene.showAndWait();


		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	 public ObservableList<SubtitleLine> getAssData() {
	        return ass;
	    }

	 public void setASSData(ObservableList<SubtitleLine> file)
	 {
		 this.ass=file;
	 }
	 public Stage getStage()
	 {
		 return this.mainStage;
	 }

	 public AssFile getFile()
	 {
		 return this.file;
	 }
}

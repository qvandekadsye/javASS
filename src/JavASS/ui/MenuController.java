package JavASS.ui;
import java.io.File;
import java.io.IOException;

import JavASS.MainClass;
import JavASS.model.SubtitleLine;
import JavASS.util.AssParser;
import javafx.fxml.FXML;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuItem;
import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;

public class MenuController {

	public AssParser parser;

	@FXML
	private Menu menu;

	@FXML
	private MenuItem nouveau;

	@FXML
	private MenuItem ouvrir;

	@FXML
	private MenuItem infoScript;

	private MainClass main;

	@FXML
	private void initailize()
	{

	}

	public void setMain(MainClass main)
	{
		this.main=main;
	}

	@FXML
	private void nouveauAction() throws IOException
	{
		FileChooser fc = new FileChooser();
		fc.setTitle("Ouvrir un fichier ASS");
		fc.setSelectedExtensionFilter(new ExtensionFilter("ass", "*.ass"));
		File file =fc.showOpenDialog(main.getStage());
		if(file != null)
		{
			this.parser=new AssParser(file.getAbsolutePath());
			this.parser.readInfo();
			main.getAssData().clear();
			this.parser.read(main.getFile().getLines());
			this.main.getFile().setInfo(this.parser.readInfo());

			main.getStage().setTitle(main.getStage().getTitle()+"-"+file.getAbsolutePath());
		}

	}

	@FXML
	private void infoAction()
	{
		main.displayInfo();

	}


}

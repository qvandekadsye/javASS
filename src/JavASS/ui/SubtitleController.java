package JavASS.ui;

import JavASS.MainClass;
import JavASS.model.SubtitleLine;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TableView.TableViewSelectionModel;
import javafx.scene.control.TextArea;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;


public class SubtitleController {
	@FXML
	private TableView<SubtitleLine> assTable;
	@FXML
	private TableColumn<SubtitleLine,Boolean>comColumn;
	@FXML
	private TableColumn<SubtitleLine,Integer>numberColumn;
	@FXML
	private TableColumn<SubtitleLine,Integer>lColumn;
	@FXML
	private TableColumn<SubtitleLine,Integer>gaucheColumn;
	@FXML
	private TableColumn<SubtitleLine,Integer>droiteColumn;
	@FXML
	private TableColumn<SubtitleLine,Integer>verticalColumn;
	@FXML
	private TableColumn<SubtitleLine,String>debutColumn;
	@FXML
	private TableColumn<SubtitleLine,String>finColumn;
	@FXML
	private TableColumn<SubtitleLine,String>styleColumn;
	@FXML
	private TableColumn<SubtitleLine,String>acteurColumn;
	@FXML
	private TableColumn<SubtitleLine,String>effetColumn;
	@FXML
	private TableColumn<SubtitleLine,String>textColumn;

	@FXML
	private TextArea line;

	private MainClass main;

	boolean firstgras=true;
	boolean firstitalic=true;
	boolean firstunder=true;

	public SubtitleController()
	{

	}
	/**Initialise le controlleur**/
	@FXML
	private void initialize()
	{

		numberColumn.setCellValueFactory(cellData ->cellData.getValue().numberProperty().asObject());
		lColumn.setCellValueFactory(cellData -> cellData.getValue().l().asObject());
		debutColumn.setCellValueFactory(cellData->cellData.getValue().debut());
		finColumn.setCellValueFactory(cellData ->cellData.getValue().fin());
		styleColumn.setCellValueFactory(cellData->cellData.getValue().style());
		acteurColumn.setCellValueFactory(cellData->cellData.getValue().acteur());
		effetColumn.setCellValueFactory(cellData->cellData.getValue().effet());
		gaucheColumn.setCellValueFactory(cellData->cellData.getValue().gauche().asObject());
		droiteColumn.setCellValueFactory(cellData->cellData.getValue().droite().asObject());
		verticalColumn.setCellValueFactory(cellData->cellData.getValue().vertical().asObject());
		textColumn.setCellValueFactory(cellData->cellData.getValue().text());
		comColumn.setCellValueFactory(cellData ->cellData.getValue().iscom());
		assTable.getSelectionModel().selectedItemProperty().addListener((observable,old,newLine)->displayTextOnTA(newLine));
		this.line.setPrefColumnCount(21);
		this.line.setOnKeyPressed(new EventHandler<KeyEvent>() {

			@Override
			public void handle(KeyEvent event) {
				if(event.isControlDown() && event.getCode()==KeyCode.B )
				{

					if(!firstgras)
					{
						SubtitleController.this.line.appendText("{/b0}");
						firstgras=true;
					}
					else
					{
						SubtitleController.this.line.appendText("/b1");
						firstgras=false;
					}
				}
				else if(event.isControlDown() && event.getCode()==KeyCode.I )
				{

					if(!firstitalic)
					{
						SubtitleController.this.line.appendText("/i0");
						firstitalic=true;
					}
					else
					{
						SubtitleController.this.line.appendText("/i1");
						firstitalic=false;
					}
				}
				else if(event.isControlDown() && event.getCode()==KeyCode.U )
				{

					if(!firstunder)
					{
						SubtitleController.this.line.appendText("/u0");
						firstunder=true;
					}
					else
					{
						SubtitleController.this.line.appendText("/u1");
						firstunder=false;
					}
				}
				else if(event.isControlDown()&&((event.getCode()==KeyCode.DIGIT1)  || (event.getCode()==KeyCode.DIGIT2) || (event.getCode()==KeyCode.DIGIT3)
						|| (event.getCode()==KeyCode.DIGIT4)||(event.getCode()==KeyCode.DIGIT5)||(event.getCode()==KeyCode.DIGIT6)||(event.getCode()==KeyCode.DIGIT7)
						||(event.getCode()==KeyCode.DIGIT8)||(event.getCode()==KeyCode.DIGIT9)))
						{
							SubtitleController.this.line.appendText("/an"+event.getCode().getName().charAt(event.getCode().getName().length()-1));
						}
				else if(event.getCode()==KeyCode.ENTER)
				{
					TableViewSelectionModel<SubtitleLine> sb =SubtitleController.this.assTable.getSelectionModel();
					if(sb.getSelectedIndex()==sb.getTableView().getItems().size()-1)
					{
						sb.getTableView().getItems().add(new SubtitleLine(false, sb.getTableView().getItems().size()+1, 0, "", "", "", "", "", 0, 0, 0, ""));
					}
					sb.getSelectedItem().setText(SubtitleController.this.line.getText());
					sb.selectNext();
				}

			}



		});

	}

	public void setMainClass(MainClass main)
	{
		this.main = main;
		//On ajoute la liste au tableau
		this.assTable.setItems(this.main.getFile().getLines());
	}

	private void displayTextOnTA(SubtitleLine line)
	{
		this.line.setText(line.getTexte());
	}


}

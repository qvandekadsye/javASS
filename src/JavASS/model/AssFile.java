package JavASS.model;

import java.util.List;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class AssFile {
	protected AssInfo info;
	protected ObservableList<SubtitleLine> lines = FXCollections.observableArrayList();
	protected List<String> style;

	public AssFile()
	{
		this.info = new AssInfo();

	}

	public AssFile(AssInfo info, ObservableList<SubtitleLine> lines, List<String> style)
	{
		this.info = info;
		this.lines = lines;
		this.style = style;
	}

	public AssInfo getInfo() {
		return info;
	}

	public ObservableList<SubtitleLine> getLines() {
		return lines;
	}

	public List<String> getStyle() {
		return style;
	}

	public void setInfo(AssInfo info) {
		this.info = info;
	}

	public void setLines(ObservableList<SubtitleLine> lines) {
		this.lines = lines;
	}

	public void setStyle(List<String> style) {
		this.style = style;
	}




}

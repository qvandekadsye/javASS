package JavASS.model;

import javafx.beans.property.BooleanProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class SubtitleLine
{
	protected final IntegerProperty number;
	protected final IntegerProperty l;
	protected final StringProperty debut;
	protected final StringProperty fin;
	protected final StringProperty style;
	protected final StringProperty acteur;
	protected final StringProperty effet;
	protected final IntegerProperty gauche;
	protected final IntegerProperty droite;
	protected final IntegerProperty vertical;
	protected final StringProperty text;
	protected final BooleanProperty iscom;
	//protected final ObjectProperty<subtitleStyle>

	/**
	 * @param number
	 * @param l
	 * @param start
	 * @param end
	 * @param style
	 * @param acteur
	 * @param effet
	 * @param gauche
	 * @param droite
	 * @param vertical
	 * @param text
	 */
	public SubtitleLine(boolean com,int number, int l, String start, String end, String style, String acteur, String effet,int gauche, int droite, int vertical, String text)
	{
		this.iscom=new SimpleBooleanProperty(com);
		this.number = new SimpleIntegerProperty(number);
		this.l = new SimpleIntegerProperty(l);
		this.debut = new SimpleStringProperty(start);
		this.fin = new SimpleStringProperty(end);
		this.style = new SimpleStringProperty(style);
		this.acteur = new SimpleStringProperty(acteur);
		this.effet = new SimpleStringProperty(effet);
		this.gauche = new SimpleIntegerProperty(gauche);
		this.droite = new SimpleIntegerProperty(droite);
		this.vertical = new SimpleIntegerProperty(vertical);
		this.text = new SimpleStringProperty(text);
	}

	public int getNumber()
	{
		return this.number.get();
	}

	public void setNumber(int number)
	{
		this.number.set(number);
	}

	public IntegerProperty numberProperty()
	{
		return number;
	}

	public int getL()
	{
		return this.l.get();
	}

	public void setL(int l)
	{
		this.l.set(l);
	}

	public IntegerProperty l()
	{
		return l;
	}

	public String getDebut()
	{
		return this.debut.get();
	}

	public void setDebut(String debut)
	{
		this.debut.set(debut);
	}

	public StringProperty debut()
	{
		return debut;
	}

	public String getFin()
	{
		return this.fin.get();
	}

	public StringProperty fin()
	{
		return fin;
	}

	public void setFin(String fin)
	{
		this.fin.set(fin);
	}



	public String getStyle()
	{
		return this.style.get();
	}

	public void setStyle(String style)
	{
		this.style.set(style);
	}

	public StringProperty style()
	{
		return style;
	}

	public String getActeur()
	{
		return this.acteur.get();
	}

	public void setActeur(String acteur)
	{
		this.acteur.set(acteur);
	}

	public StringProperty acteur()
	{
		return acteur;
	}

	public String getEffet()
	{
		return this.effet.get();
	}

	public void setEffet(String effet)
	{
		this.effet.set(effet);
	}

	public StringProperty effet()
	{
		return effet;
	}

	public int getGauche()
	{
		return this.gauche.get();
	}

	public void setGauche(int gauche)
	{
		this.gauche.set(gauche);
	}

	public IntegerProperty gauche()
	{
		return gauche;
	}

	public int getDroite()
	{
		return this.droite.get();
	}

	public void setDroite(int droite)
	{
		this.droite.set(droite);
	}

	public IntegerProperty droite()
	{
		return droite;
	}

	public int getVertical()
	{
		return this.vertical.get();
	}

	public void setVertical(int vertical)
	{
		this.vertical.set(vertical);
	}

	public IntegerProperty vertical()
	{
		return vertical;
	}

	public String getTexte()
	{
		return this.text.get();
	}

	public void setText(String text)
	{
		this.text.set(text);
	}

	public StringProperty text()
	{
		return this.text;
	}

	public boolean getCom()
	{
		return this.iscom.get();
	}

	public void setCom(boolean com)
	{
		this.iscom.set(com);
	}

	public BooleanProperty iscom()
	{
		return this.iscom;
	}

}

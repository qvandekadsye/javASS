package JavASS.util;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;

import JavASS.model.AssFile;
import JavASS.model.AssInfo;
import JavASS.model.SubtitleLine;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class AssParser {
	String path;
	BufferedReader br;
	BufferedWriter bw;

	public AssParser(String chemin)
	{
		this.path=chemin;
	}

	public void read(ObservableList<SubtitleLine> tab)
	{
		boolean iscom;
		int nb=0;
		String line =null;
		String title="";
		int wrapStyle=0;
		boolean flag=false;
		boolean info =false;
		boolean assinfobool=false;
		String[] parse, parseBis;
		ObservableList<SubtitleLine> ass = FXCollections.observableArrayList();
		AssInfo infoprop;

		try {
			while((line=this.br.readLine()) != null)
			{
				if(!assinfobool)
				{

				}

				if(flag && info)
				{
					parse=line.split(",", 10);
					parseBis = parse[0].split(": ");
					if(parseBis[0].startsWith("Dialogue"))
					{
						iscom=false;
					}
					else
						iscom=true;
					byte[] btext = parse[9].getBytes();
					SubtitleLine sl = new SubtitleLine(iscom,nb, Integer.parseInt(parseBis[1]), parse[1], parse[2], parse[3], parse[4], parse[8], Integer.parseInt(parse[5]), Integer.parseInt(parse[6]), Integer.parseInt(parse[7]), new String(btext,"UTF-8"));
					tab.add(sl);
					nb++;

				}
				if(line.equals("[Events]"))
					flag=true;
				if(line.endsWith("ormat: Layer, Start, End, Style, Name, MarginL, MarginR, MarginV, Effect, Text"))
					info=true;
			}
			br.close();

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}



	}

	public AssInfo readInfo() throws IOException
	{
		String line = null;
		AssInfo info = new AssInfo();
		this.br = new BufferedReader(new FileReader(this.path));
		while((line=br.readLine()) != null)
		{
			if(line.startsWith("Title: "))
			{
				System.out.println(line.substring("Titre: ".length()));
				info.setTitre(line.substring("Titre: ".length()));
			}
			else if(line.startsWith("WrapStyle: "))
			{
				System.out.println(line.substring("WrapStyle: ".length()));
				info.setWrapStyle(Integer.parseInt(line.substring("WrapStyle: ".length())));
			}
			else if(line.startsWith("ScaledBorderAndShadow: "))
			{
				System.out.println(line.substring("ScaledBorderAndShadow: ".length()));
				String res = line.substring("ScaledBorderAndShadow: ".length());
				info.setScale(res.equals("yes"));
			}
			else if(line.startsWith("YCbCr Matrix: "))
			{
				System.out.println(line.substring("YCbCr Matrix: ".length()));
				info.setYCbCr(line.substring("YCbCr Matrix: ".length()));
			}
			else if(line.startsWith("Original Script: "))
			{
				System.out.println(line.substring("Original Script: ".length()));
				info.setOriginalScript(line.substring("Original Script: ".length()));
			}
			else if(line.startsWith("Original Translation: "))
			{
				System.out.println(line.substring("Original Translation: ".length()));
				info.setTraduction(line.substring("Original Translation: ".length()));
			}
			else if(line.startsWith("Original Editing: "))
			{
				System.out.println(line.substring("Original Editing: ".length()));
				info.setEdition(line.substring("Original Editing: ".length()));
			}
			else if(line.startsWith("Original Timing: "))
			{
				System.out.println(line.substring("Original Timing: ".length()));
				info.setTiming(line.substring("Original Timing: ".length()));
			}
			else if(line.startsWith("Synch Point: "))
			{
				System.out.println(line.substring("Synch Point: ".length()));
				info.setSynch(line.substring("Synch Point: ".length()));
			}
			else if(line.startsWith("Script Updated By: "))
			{
				System.out.println(line.substring("Script Updated By: ".length()));
				info.setUpdatedBy(line.substring("Script Updated By: ".length()));
			}
			else if(line.startsWith("Update Details: "))
			{
				System.out.println(line.substring("Update Details: ".length()));
				info.setUpdateDetails(line.substring("Update Details: ".length()));
			}
			else if(line.startsWith("PlayResX: "))
			{
				System.out.println(line.substring("PlayResX: ".length()));
				info.setResX(Integer.parseInt((line.substring("PlayResX: ".length()))));
			}
			else if(line.startsWith("PlayResY: "))
			{
				System.out.println(line.substring("PlayResY: ".length()));
				info.setResY(Integer.parseInt((line.substring("PlayResY: ".length()))));
				break;
			}
		}
		return info;
	}

	public static void writeASSText(AssFile file, String path) throws IOException
	{
		File fichier = new File(path);
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(fichier),"UTF-8"));
		out.write("[Events]\n");
		out.write("Format: Layer, Start, End, Style, Name, MarginL, MarginR, MarginV, Effect, Text\n");
		for(SubtitleLine sl : file.getLines())
		{
			if(!sl.getCom())
			{
				out.write("Dialogue: ");
			}
			out.write(sl.getL()+",");
			out.write(sl.getDebut()+",");
			out.write(sl.getFin()+",");
			out.write(sl.getStyle()+",");
			out.write(sl.getActeur());
			out.write(sl.getGauche()+",");
			out.write(sl.getDroite()+",");
			out.write(sl.getVertical()+",");
			out.write(sl.getEffet()+",");
			out.write(sl.getTexte());
		}
		out.close();

	}

}



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
import java.util.ArrayList;

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

		}



	}

	public AssInfo readInfo() throws IOException
	{
		String line = null;
		AssInfo info = new AssInfo();
		this.br = new BufferedReader(new FileReader(this.path));
		while((line=br.readLine().replaceAll(" ", "")) != null && !line.equals("[V4+ Styles]"))
		{System.out.println(line);
			if(line.startsWith("Title:"))
			{
				System.out.println(line.substring("Titre:".length()));
				info.setTitre(line.substring("Titre:".length()));
			}
			else if(line.startsWith("WrapStyle:"))
			{
				System.out.println(line.substring("WrapStyle:".length()));
				info.setWrapStyle(Integer.parseInt(line.substring("WrapStyle:".length())));
			}
			else if(line.startsWith("ScaledBorderAndShadow:"))
			{
				System.out.println(line.substring("ScaledBorderAndShadow:".length()));
				String res = line.substring("ScaledBorderAndShadow:".length());
				info.setScale(res.equals("yes"));
			}
			else if(line.startsWith("YCbCrMatrix:"))
			{
				System.out.println(line.substring("YCbCrMatrix:".length()));
				info.setYCbCr(line.substring("YCbCrMatrix:".length()));
			}
			else if(line.startsWith("OriginalScript:"))
			{
				System.out.println(line.substring("OriginalScript:".length()));
				info.setOriginalScript(line.substring("OriginalScript:".length()));
			}
			else if(line.startsWith("OriginalTranslation:"))
			{
				System.out.println(line.substring("OriginalTranslation:".length()));
				info.setTraduction(line.substring("Original Translation:".length()));
			}
			else if(line.startsWith("OriginalEditing:"))
			{
				System.out.println(line.substring("OriginalEditing:".length()));
				info.setEdition(line.substring("Original Editing:".length()));
			}
			else if(line.startsWith("OriginalTiming:"))
			{
				System.out.println(line.substring("OriginalTiming:".length()));
				info.setTiming(line.substring("OriginalTiming:".length()));
			}
			else if(line.startsWith("SynchPoint:"))
			{
				System.out.println(line.substring("SynchPoint:".length()));
				info.setSynch(line.substring("SynchPoint:".length()));
			}
			else if(line.startsWith("ScriptUpdatedBy:"))
			{
				System.out.println(line.substring("ScriptUpdatedBy:".length()));
				info.setUpdatedBy(line.substring("ScriptUpdatedBy:".length()));
			}
			else if(line.startsWith("UpdateDetails:"))
			{
				System.out.println(line.substring("UpdateDetails:".length()));
				info.setUpdateDetails(line.substring("UpdateDetails:".length()));
			}
			else if(line.startsWith("PlayResX:"))
			{
				System.out.println(line.substring("PlayResX:".length()));
				info.setResX(Integer.parseInt((line.substring("PlayResX:".length()))));
			}
			else if(line.startsWith("PlayResY:"))
			{
				System.out.println(line.substring("PlayResY:".length()));
				info.setResY(Integer.parseInt((line.substring("PlayResY:".length()))));
				break;
			}
		}
		return info;
	}

	public ArrayList<String> readStyleLine() throws IOException
	{
		ArrayList<String> styles = new ArrayList<>();
		String line = null;

			while((line=this.br.readLine()).equals("[Events]"))
			{
				if(!line.isEmpty())
					styles.add(line);
			}
			return styles;

	}


	public static void writeASSInfo(AssFile file, String path, BufferedWriter out) throws IOException
	{

		out.write("[Script Info]\n");
		out.write("; Script generated by JavASS 0.1\n");
		out.write("; Quentin Van de kadsye\n");
		out.write("Title: "+file.getInfo().getTitre()+"\n");
		out.write("ScriptType: v4.00+\n");
		out.write("WrapStyle: "+file.getInfo().getWrapStyle()+"\n");
		out.write("ScaledBorderAndShadow: ");
		if(file.getInfo().getScale())
			out.write("yes\n");
		else
			out.write("no\n");
		out.write("YCbCr Matrix: "+file.getInfo().getYCbCr()+"\n");
		out.write("Original Script: "+file.getInfo().getOriginalScript()+"\n");
		out.write("Original Translation: "+file.getInfo().getTraduction()+"\n");
		out.write("Original Editing: "+file.getInfo().getEdition()+"\n");
		out.write("Original Timing: "+file.getInfo().getTiming()+"\n");
		out.write("Synch Point: "+file.getInfo().getSynch()+"\n");
		out.write("Script Updated By: "+file.getInfo().getUpdatedBy()+"\n");
		out.write("Update Details: "+file.getInfo().getUpdateDetails()+"\n");
		out.write("PlayResX: "+file.getInfo().getResX()+"\n");
		out.write("PlayResY: "+file.getInfo().getResY()+"\n");
		out.write("\n");
		out.write("[Aegisub Project Garbage]");
		out.write("\n");



	}

	public static void writeASSText(AssFile file, String path,BufferedWriter out) throws IOException
	{

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
			out.write(sl.getActeur()+",");
			out.write(sl.getGauche()+",");
			out.write(sl.getDroite()+",");
			out.write(sl.getVertical()+",");
			out.write(sl.getEffet()+",");
			out.write(sl.getTexte()+"\n");
		}
		out.close();

	}

	public static void writeASS(AssFile file, String path) throws IOException
	{
		File fichier = new File(path);
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(fichier),"UTF-8"));
		writeASSInfo(file, path,out);
		writeASSStyle(file,path,out);
		writeASSText(file, path,out);
		out.close();
	}

	public static void writeASSStyle(AssFile file, String path,BufferedWriter out) throws IOException
	{
		out.write("[V4+ Styles]");
		for(String style : file.getStyle())
		{
			out.write(style+"\n");
		}
	}



}



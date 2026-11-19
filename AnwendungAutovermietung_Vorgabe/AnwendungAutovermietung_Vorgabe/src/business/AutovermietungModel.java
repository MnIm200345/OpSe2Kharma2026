package business;

import fileCreatorsKharma.*;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class AutovermietungModel {
	private Auto auto;

	public Auto getAuto() {
		return auto;
	}

	public void setAuto(Auto auto) {
		this.auto = auto;
	}
	
	
	public void leseAusDatei(String typ) throws IOException{
		ReaderCreatorKharma readerCreatorKharma = null;
		if("csv".equals(typ)) {
			readerCreatorKharma = new ConcreteCsvCreator();
		}else {
			readerCreatorKharma = new ConcreteTxtCreator();
		}
		
		ReaderProductKharma reader = readerCreatorKharma.factorymethod();
		String[] zeile = reader.leseAusDatei();
		this.auto = new Auto(zeile[0], 
				zeile[1], 
				zeile[2], 
				Float.parseFloat(zeile[3]), 
				zeile[4].split("_")
				
				);
		
		reader.schliesseDatei();
	}
	
	public void schreibeAutoInCsvDatei() throws IOException{
		
			BufferedWriter aus 
				= new BufferedWriter(new FileWriter("AutosAusgabe.csv", true));
			aus.write(auto.gibAutoZurueck(';'));
			aus.close();
   			
	}

	
}

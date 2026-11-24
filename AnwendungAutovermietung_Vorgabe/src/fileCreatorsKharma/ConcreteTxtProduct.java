package fileCreatorsKharma;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ConcreteTxtProduct extends ReaderProductKharma{
	private BufferedReader ein;
	
	public ConcreteTxtProduct() throws IOException {
		// TODO Auto-generated constructor stub
		this.ein =  new BufferedReader(new FileReader("Auto.txt"));
	}
	
	@Override
	public String[] leseAusDatei() throws IOException {
		String[] ergebnisZeile  = new String[5];
		String zeile =ein.readLine();
		int i = 0;
		
		while(i < ergebnisZeile.length) {
			ergebnisZeile[i] = zeile;
			zeile = ein.readLine();
			i++;
		}
		
		return ergebnisZeile;
	}

	@Override
	public void schliesseDatei() throws IOException {
		// TODO Auto-generated method stub
		this.ein.close();
		
	}
	
	
	
}

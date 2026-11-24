package fileCreatorsKharma;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ConcreteCsvProduct extends ReaderProductKharma{
	private BufferedReader ein;
	
	public ConcreteCsvProduct() throws IOException {
		// TODO Auto-generated constructor stub
		this.ein =  new BufferedReader(new FileReader("Auto.csv"));
	}
	
	@Override
	public String[] leseAusDatei() throws IOException {
		// TODO Auto-generated method stub
		String[] zeile = ein.readLine().split(";");
		return zeile;
	}

	@Override
	public void schliesseDatei() throws IOException {
		// TODO Auto-generated method stub
		this.ein.close();
		
	}
	
	
	
}

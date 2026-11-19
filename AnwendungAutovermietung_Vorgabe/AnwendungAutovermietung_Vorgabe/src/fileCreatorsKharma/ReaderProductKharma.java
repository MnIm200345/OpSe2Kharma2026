package fileCreatorsKharma;

import java.io.IOException;

public abstract class ReaderProductKharma {
	public abstract String[] leseAusDatei()  throws IOException;
	public abstract void schliesseDatei() throws IOException;
}

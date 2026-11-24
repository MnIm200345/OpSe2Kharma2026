package fileCreatorsKharma;

import java.io.IOException;

public class ConcreteCsvCreator extends ReaderCreatorKharma{

	@Override
	public ReaderProductKharma factorymethod() throws IOException {
		return new ConcreteCsvProduct();
	}

}

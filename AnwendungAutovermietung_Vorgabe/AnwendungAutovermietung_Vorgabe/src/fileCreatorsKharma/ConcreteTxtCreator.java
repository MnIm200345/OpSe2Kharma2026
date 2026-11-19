package fileCreatorsKharma;

import java.io.IOException;

public class ConcreteTxtCreator extends ReaderCreatorKharma{
	@Override
	public ReaderProductKharma factorymethod() throws IOException {
		// TODO Auto-generated method stub
		return new ConcreteTxtProduct();
	}
}

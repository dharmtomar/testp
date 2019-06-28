package test_Pages;

import java.io.IOException;

import org.testng.annotations.Test;

import object_Pages.Benefile;

public class Benefile_Test extends Baseclass {

	Benefile bene;
	@Test
	public void benetest() throws IOException{
		bene=new Benefile(odriver);
		bene.beneclick();
	}
}

package test_Pages;

import java.io.IOException;

import org.testng.annotations.Test;

import object_Pages.Cardreports;

public class Cardreport_Test extends Baseclass {

	Cardreports cd;
	@Test
	public void cardreportdownload() throws IOException {
		cd=new Cardreports(odriver);
		cd.downloadcardreports();
	}
}

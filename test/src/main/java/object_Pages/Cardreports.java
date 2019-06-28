package object_Pages;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import utils.Common_Methods;

public class Cardreports extends Common_Methods{

	public WebDriver odriver;
	public Cardreports(WebDriver odriver) {
		this.odriver=odriver;
	}
	public void downloadcardreports() throws IOException {
		custom_Click(odriver, By.xpath(getlocvalue("cardtxnlink")), 15);
		custom_Click(odriver, By.xpath(getlocvalue("mdrreport")), 15);
		custom_Click(odriver, By.xpath(getlocvalue("cardfromdatefilter")), 15);
		custom_Click(odriver, By.xpath(getlocvalue("cfromdate")), 15);
	}
}

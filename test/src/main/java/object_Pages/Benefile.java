package object_Pages;

import java.io.IOException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

import utils.Common_Methods;

public class Benefile extends Common_Methods{

	public WebDriver odriver;
	public Benefile(WebDriver odriver) {
		this.odriver=odriver;
	}
	public void beneclick() throws IOException{
		custom_Click(odriver, By.xpath(getlocvalue("benelink")), 15);
		// This is to right click on benelink
		//Actions ac=new Actions(odriver);
		//ac.contextClick(odriver.findElement(By.xpath(getlocvalue("benelink")))).build().perform();
		//System.out.println(odriver.findElement(By.xpath(getlocvalue("merchantlist"))).isEnabled());
		custom_Click(odriver, By.xpath(getlocvalue("benefrom")), 15);
		custom_Click(odriver, By.xpath(getlocvalue("fromdate")), 15);
		custom_Click(odriver, By.xpath(getlocvalue("beneto")), 15);
		custom_Click(odriver, By.xpath(getlocvalue("todate")), 15);
		custom_Click(odriver, By.xpath(getlocvalue("benegenerate")), 15);
	}
}

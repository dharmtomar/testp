package object_Pages;

import static org.testng.Assert.assertEquals;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import utils.Common_Methods;

public class HomepageRefresh extends Common_Methods{

	public WebDriver odriver;
	public HomepageRefresh(WebDriver odriver) {
		this.odriver=odriver;
		odriver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
	}
	public void RefreshHome()throws IOException {
		System.out.println("In Home page refresh");
		//odriver.findElement(By.xpath("//*[@id=\"sidebar-menu\"]/div/ul/li[2]/a")).click();
		custom_Click(odriver, By.xpath(getlocvalue("Homepage")), 15);
		//odriver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		//System.out.println(odriver.getTitle());
		assertEquals(odriver.getTitle(), getdatavalue("homepagetitle"));
	}
}

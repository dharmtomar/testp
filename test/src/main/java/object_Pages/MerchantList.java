package object_Pages;

import java.awt.Window;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import utils.Common_Methods;

public class MerchantList extends Common_Methods {

	public WebDriver odriver;
	public MerchantList(WebDriver odriver) {
		this.odriver=odriver;
	}
	public void merchantList() throws IOException, InterruptedException{
		custom_Click(odriver, By.xpath(getlocvalue("managemerchant")), 15);
		custom_Click(odriver, By.xpath(getlocvalue("merchantlist")), 15);
		odriver.findElement(By.xpath("//*[@id=\"ShowMerchantDetails\"]/button")).click();
		/*Select sl=new Select(odriver.findElement(By.xpath("//Select[@id='BusinessType']")));
		System.out.println(sl.getFirstSelectedOption().getText());
		List<WebElement> el=sl.getOptions();
		for(WebElement elmnt:el) {
			System.out.println(elmnt.getText());	
		}*/
		JavascriptExecutor jex=(JavascriptExecutor)odriver;
		jex.executeScript("window.scrollTo(0, document.body.scrollHeight)");
		Thread.sleep(2000);
		jex.executeScript("window.scrollBy(0,-2000)");
	}
}

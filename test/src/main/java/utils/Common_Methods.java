package utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import javax.swing.plaf.FileChooserUI;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Common_Methods {

	static Properties locators;
	static Properties testdata;
	static File configfile;
	static FileInputStream filestream;
	public static WebDriver odriver;
	
	public void initialization() throws IOException {
		selectBrowser(getdatavalue("browser"));
		odriver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		odriver.manage().window().maximize();
		odriver.get(getdatavalue("BaseURL"));
		loginERP();
	}
	public void selectBrowser(String browsername)throws IOException {
		if(browsername.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"/Drivers/chromedriver.exe");
			odriver=new ChromeDriver();
			
		}
		else if(browsername.equalsIgnoreCase("firefox")) {
			System.setProperty("webdriver.firefox.driver"+System.getProperty("user.dir"),"/Drivers/firefox.exe");
			odriver=new FirefoxDriver();
		}
	}
	public  static void loadproperties(String datatype)throws IOException {
		if(datatype.equalsIgnoreCase("loc")) {
			locators=new Properties();
			configfile=new File(System.getProperty("user.dir")+"/src/main/java/config/locaters.properties");
			filestream=new FileInputStream(configfile);
			locators.load(filestream);
		}
		else if(datatype.equalsIgnoreCase("data")) {
			testdata=new Properties();
			configfile=new File(System.getProperty("user.dir")+"/src/main/java/config/testdata.properties");
			filestream=new FileInputStream(configfile);
			testdata.load(filestream);
		}
	}
	public static String getlocvalue(String key) throws IOException {
		loadproperties("loc");
		String path=locators.getProperty(key);
		return path;	
	}
	public static String getdatavalue(String key) throws IOException {
		loadproperties("data");
		String path=testdata.getProperty(key);
		return path;	
	}
	public static void custom_Click(WebDriver odriver,By by,int wait) throws IOException {
		explicit_wait(odriver,by,wait);
		odriver.findElement(by).click();
	}
	
	public static void enter_text(WebDriver odriver,By by,String text,int wait) throws IOException {
		explicit_wait(odriver,by,wait);
		odriver.findElement(by).sendKeys(text);
	}
	public static void explicit_wait(WebDriver odriver,By by,int wait) {
		WebDriverWait wait2=new WebDriverWait(odriver, wait);
		wait2.until(ExpectedConditions.presenceOfElementLocated(by));
	}
	public static void loginERP() throws IOException{
		enter_text(odriver, By.xpath(Common_Methods.getlocvalue("loginid")), Common_Methods.getdatavalue("LoginID"), 15);
		enter_text(odriver, By.xpath(getlocvalue("password")), getdatavalue("Password"), 15);
		custom_Click(odriver, By.xpath(getlocvalue("Submit")), 15);
	}
	public void closebrowser() {
		odriver.close();
	}
	public void logoutERP() {
		
	}
public static void takescreenshot() throws Exception {
		
		File src;
		TakesScreenshot screen=(TakesScreenshot)odriver;
		src=screen.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(src, new File(System.getProperty("user.dir")+ "/Screenshots/"+timestamp()+".png"));
		System.out.println("Screen Captured");	
	}
public static String timestamp() {
	String timestamp=new SimpleDateFormat("yyyyMMhhmmss").format(new Date());
	return timestamp;
}
}

package test_Pages;

import java.io.IOException;

import org.testng.annotations.Test;

import object_Pages.HomepageRefresh;

public class Homerefresh_Test extends Baseclass {

	HomepageRefresh home;
	@Test
	public void homerefresh() throws Exception {
		home=new HomepageRefresh(odriver);
		home.RefreshHome();
		
		//home.takescreenshot();
	}
}

package test_Pages;

import java.io.IOException;

import org.testng.annotations.Test;

import object_Pages.MerchantList;

public class MerchantList_Test extends Baseclass {

	MerchantList list;
	@Test
	public void merchantlist_Test() throws IOException, InterruptedException {
		list=new MerchantList(odriver);
		list.merchantList();
	}
}

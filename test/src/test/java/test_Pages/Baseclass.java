package test_Pages;

import java.io.IOException;

import org.testng.annotations.BeforeSuite;

import org.testng.annotations.Test;

import utils.Common_Methods;

public class Baseclass extends Common_Methods {

	@BeforeSuite
	public void setup() throws IOException{
		initialization();
	}
	@Test
	public void test() {
		System.out.println("just for test");
	}
}

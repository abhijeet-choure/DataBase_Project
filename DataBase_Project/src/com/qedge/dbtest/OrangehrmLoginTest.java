package com.qedge.dbtest;

import org.apache.log4j.Logger;
import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class OrangehrmLoginTest 
{
private static Logger log=
						Logger.getLogger(OrangehrmLoginTest.class);

	public static void main(String[] args) 
	{
	
		DOMConfigurator.configure("log4j.xml");
		WebDriver driver=new FirefoxDriver();
		driver.get("http://orangehrm.qedgetech.com");
		log.info("Application Launched...");

	}

}

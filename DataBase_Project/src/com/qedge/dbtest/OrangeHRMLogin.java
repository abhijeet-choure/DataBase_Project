package com.qedge.dbtest;

import org.apache.log4j.Logger;
import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


public class OrangeHRMLogin 
{
	private static Logger log=Logger.getLogger(OrangeHRMLogin.class);
	

	public static void main(String[] args) 
	{
		DOMConfigurator.configure("log4j.xml");
		
		String exptitle,acttitle;
		exptitle="HRMS";
		
		WebDriver driver=new FirefoxDriver();		
		log.info("Browser Launched");
		driver.get("http://orangehrm.qedgetech.com");
		log.info("OrangeHRM Application Launched");
		
		acttitle=driver.getTitle();
		if (exptitle.equals(acttitle)) 
		{
			log.info("Test Pass");
		}else
		{
			log.debug(exptitle+" "+acttitle);
		}
		
		try 
		{
			driver.findElement(By.id("txtuid")).sendKeys("Admin");
		} catch (Exception e) 
		{
			log.fatal("UserName element not found");
		}

	}

}

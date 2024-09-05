package testcases;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import base.BaseTest;
import utilities.ReadXLSdata;

public class FirstTestCaseN extends BaseTest{
	
	@Test (dataProviderClass=ReadXLSdata.class,dataProvider="Devlogindata")
	public static void loginTest(String username, String password) {
		driver.findElement(By.linkText(loc.getProperty("Sign_in"))).click();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(loc.getProperty("login_id"))));
		element.sendKeys(username);

        driver.findElement(By.id(loc.getProperty("click_nextbtn1"))).click();
        element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(loc.getProperty("password"))));
		element.sendKeys(password);
		driver.findElement(By.id(loc.getProperty("click_nextbtn2"))).click();
		element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(loc.getProperty("Skip_for_now"))));
		element.click();
	}
	
	
	
}

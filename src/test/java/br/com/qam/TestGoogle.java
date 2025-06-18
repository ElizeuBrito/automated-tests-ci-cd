package br.com.qam;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;

public class TestGoogle {

    @Test
    public void googleSearch() throws MalformedURLException, InterruptedException {

        URL seleniumUrl = new URL("http://localhost:4444/wd/hub");
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setBrowserName("chrome");

        WebDriver driver = new RemoteWebDriver(seleniumUrl, capabilities);

        driver.get("https://www.google.com");
        WebElement searchBox = driver.findElement(By.name("q"));
        searchBox.sendKeys("Selenium webdriver");
        searchBox.submit();

        Thread.sleep(3000);

        driver.quit();
    }
}

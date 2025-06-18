package br.com.qam;

import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;

@Epic("Google search engine")
@Feature("Searches passing criteria")
@Story("Search with success")
@DisplayName("Valid search with criteria test")
public class GoogleTest {

    @Test
    @Description("Tests if the search was successfully")
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

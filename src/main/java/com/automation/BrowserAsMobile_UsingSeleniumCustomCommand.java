package com.automation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.v144.emulation.Emulation;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Optional;

public class BrowserAsMobile_UsingSeleniumCustomCommand {
    public static void main(String[] args) {
        ChromeDriver driver = new ChromeDriver();
        DevTools devTools = driver.getDevTools();
        devTools.createSession();
        devTools.send(Emulation.setDeviceMetricsOverride(350,600,60,true, Optional.empty(),Optional.empty(),Optional.empty(),Optional.empty(),Optional.empty(),Optional.empty(),Optional.empty(),Optional.empty(),Optional.empty(),Optional.empty()));
        driver.get("https://rahulshettyacademy.com/angularAppdemo/");
        driver.findElement(By.className("navbar-toggler")).click();
        WebElement cartElement = driver.findElement(By.cssSelector("a[routerlink='/cart']"));
        WebDriverWait wait =  new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOf(cartElement));
        cartElement.click();
    }
}

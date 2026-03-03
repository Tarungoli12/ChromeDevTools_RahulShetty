package com.automation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import java.util.HashMap;

public class BrowserAsMobile_UsingCDPCommand {
    public static void main(String[] args) {
        ChromeDriver driver = new ChromeDriver();
        DevTools devTools = driver.getDevTools();
        devTools.createSession();
        HashMap<String,Object> map = new HashMap<>();
        map.put("width",350);
        map.put("height",600);
        map.put("deviceScaleFactor",60);
        map.put("mobile",true);
        driver.executeCdpCommand("Emulation.setDeviceMetricsOverride",map);
        driver.get("https://rahulshettyacademy.com/angularAppdemo/");
        driver.findElement(By.className("navbar-toggler")).click();
        WebElement cartElement = driver.findElement(By.cssSelector("a[routerlink='/cart']"));
        WebDriverWait wait =  new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOf(cartElement));
        cartElement.click();
    }
}

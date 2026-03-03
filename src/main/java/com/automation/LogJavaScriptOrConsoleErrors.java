package com.automation;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.logging.LogType;

public class LogJavaScriptOrConsoleErrors {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.get("https://rahulshettyacademy.com/angularAppdemo/");
        driver.findElement(By.cssSelector("p a")).click();
        driver.findElement(By.cssSelector("li[class='list-group-item'] a")).click();
        driver.findElement(By.cssSelector("button[class*='add-to-cart']")).click();
        driver.findElement(By.cssSelector("a[routerlink='/cart']")).click();
        driver.findElement(By.id("exampleInputEmail1")).sendKeys(Keys.chord(Keys.DELETE),"2");

        LogEntries entries = driver.manage().logs().get(LogType.BROWSER);
        entries.getAll().forEach(System.out::println);
    }
}

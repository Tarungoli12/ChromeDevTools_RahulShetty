package com.automation;

import com.google.common.collect.ImmutableList;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.v144.network.Network;
import java.util.Optional;

public class BlockingUnwantedNetworkReqCalls {
    public static void main(String[] args) {
        ChromeDriver driver = new ChromeDriver();
        DevTools devTools = driver.getDevTools();
        devTools.createSession();

        devTools.send(Network.enable(Optional.empty(),Optional.empty(),Optional.empty(),Optional.empty(),Optional.empty()));

        //blocking the css and jpg or image network calls
        devTools.send(Network.setBlockedURLs(Optional.empty(), Optional.of(ImmutableList.of("*jpg", "*.css"))));

        long startTime = System.currentTimeMillis();

        driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");
        driver.findElement(By.xpath("(//button[text()='ADD TO CART'])[1]")).click();
        driver.findElement(By.className("cart-icon")).click();
        driver.findElement(By.xpath("//button[text()='PROCEED TO CHECKOUT']")).click();

        long endTime = System.currentTimeMillis();

        System.out.println(endTime-startTime);
    }
}

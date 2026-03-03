package com.automation;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.v144.network.Network;
import org.openqa.selenium.devtools.v144.network.model.ConnectionType;
import org.openqa.selenium.devtools.v144.network.model.NetworkConditions;

import java.util.List;
import java.util.Optional;

public class EmulateNetworkSpeed {
    public static void main(String[] args) {
        ChromeDriver driver = new ChromeDriver();
        DevTools devTools = driver.getDevTools();
        devTools.createSession();

        devTools.send(Network.enable(Optional.empty(),Optional.empty(),Optional.empty(),Optional.empty(),Optional.empty()));
        devTools.send(Network.setCacheDisabled(true));
        devTools.send(Network.emulateNetworkConditionsByRule(true, List.of(new NetworkConditions("*",3000,200000,200000,
                Optional.of(ConnectionType.WIFI),Optional.empty(),Optional.empty(),Optional.empty()))));

        devTools.addListener(Network.loadingFailed(),loadingFailed -> {
            System.out.println(loadingFailed.getErrorText());
            System.out.println(loadingFailed.getTimestamp());
        });


        long startTime = System.currentTimeMillis();

        driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");
        driver.findElement(By.xpath("(//button[text()='ADD TO CART'])[1]")).click();
        driver.findElement(By.className("cart-icon")).click();
        driver.findElement(By.xpath("//button[text()='PROCEED TO CHECKOUT']")).click();

        long endTime = System.currentTimeMillis();

        System.out.println(endTime-startTime);

        driver.close();
    }
}

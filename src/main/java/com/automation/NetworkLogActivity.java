package com.automation;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.v144.network.Network;
import org.openqa.selenium.devtools.v144.network.model.Request;
import org.openqa.selenium.devtools.v144.network.model.Response;
import java.util.Optional;

public class NetworkLogActivity {
    public static void main(String[] args) {
        ChromeDriver driver = new ChromeDriver();
        DevTools devTools = driver.getDevTools();
        devTools.createSession();
        devTools.send(Network.enable(Optional.empty(),Optional.empty(),Optional.empty(),Optional.empty(),Optional.empty()));

        devTools.addListener(Network.requestWillBeSent(),request ->
        {
            Request req = request.getRequest();
            System.out.println("Request URL - " + req.getUrl() + " Request Headers - " + req.getHeaders());
        });

        devTools.addListener(Network.responseReceived(),response ->
        {
            Response res = response.getResponse();
            if(res.getStatus().toString().startsWith("4")){
                System.err.println(res.getUrl() + "is failing with status code" + res.getStatus());
            }
            System.out.println("Response URL - " + res.getUrl() + "with status code " + res.getStatus().toString());
        });
        driver.get("https://rahulshettyacademy.com/angularAppdemo/");
        driver.findElement(By.cssSelector("button[routerlink='/library']")).click();
    }
}

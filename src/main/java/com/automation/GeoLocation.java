package com.automation;

import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.edge.EdgeDriver;
import java.util.HashMap;
import java.util.Map;

public class GeoLocation {
    public static void main(String[] args) {
        EdgeDriver driver = new EdgeDriver();
        DevTools devTools = driver.getDevTools();
        devTools.createSession();
        Map<String,Object> map = new HashMap<>();
        map.put("latitude",40.4168);
        map.put("longitude",-3.7038);
        map.put("accuracy",1);
        driver.executeCdpCommand("Emulation.setGeolocationOverride",map);
        driver.manage().window().maximize();
        driver.get("https://linkedin.com/");

//        driver.findElement(By.cssSelector("a[title='YouTube Home']")).click();
//        driver.findElement(By.name("q")).sendKeys("Today news", Keys.ENTER);
    }
}

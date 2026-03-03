package com.automation;
import org.openqa.selenium.UsernameAndPassword;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.DevTools;

import java.net.URI;
import java.util.function.Predicate;

public class BasicAuthentication {
    public static void main(String[] args) {
        ChromeDriver driver = new ChromeDriver();
        DevTools devTools = driver.getDevTools();
        devTools.createSession();
        Predicate<URI> uriPredicate = uri -> uri.getHost().contains("httpbin.org");
        driver.register(uriPredicate, UsernameAndPassword.of("foo","bar"));
        driver.get("http://httpbin.org/basic-auth/foo/bar");
    }
}

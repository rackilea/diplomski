package com.test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class App {

public static void main( String[] args ) {
    App app = new App();
    List<String> links = app.parseLinks();
    links.forEach(System.out::println);
}

public List<String> parseLinks() {
    try {
        WebDriver driver ;
        // should download geckodriver https://github.com/mozilla/geckodriver/releases and set according your local file
        System.setProperty("webdriver.firefox.marionette","C:\\apps\\geckodriver.exe");
        driver = new FirefoxDriver();
        String baseUrl = "http://www.flashscore.com/nhl/";

        driver.get(baseUrl);

        return driver.findElement(By.className("hockey"))
                .findElements(By.tagName("tr"))
                .stream()
                .distinct()
                .filter(we -> !we.getAttribute("id").isEmpty())
                .map(we -> createLink(we.getAttribute("id")))
                .collect(Collectors.toList());

    } catch (Exception e) {
        e.printStackTrace();
        return Collections.EMPTY_LIST;
    }
}

private String createLink(String id) {
    return String.format("http://www.flashscore.com/match/%s/#match-summary", extractId(id));
}

private String extractId(String id) {
    if (id.contains("x_4_")) {
        id = id.replace("x_4_","");
    } else if (id.contains("g_4_")) {
        id = id.replace("g_4_","");
    }

    return id;
}
}
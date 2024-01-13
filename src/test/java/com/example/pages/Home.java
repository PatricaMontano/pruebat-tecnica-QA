package com.example.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.time.Duration;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.TimeUnit;
import java.util.regex.Pattern;

import static java.util.Map.entry;

public class Home {

    public static final String URL = "https://www.clubpromerica.com/costarica/";
    private WebDriver driver;

    public Home(WebDriver driver){
        this.driver = driver;
    }


    public void selectSubcategorie(String name){
        this.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
        WebElement element = this.driver.findElement(By.xpath("//span[.='"+name+"']"));
        element.click();
    }

    public void scrollView(int number){
        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        jsExecutor.executeScript("window.scrollBy(0,"+number+");");
    }

    public boolean verifyGridByName(String name){
        WebElement element = this.driver.findElement(By.xpath("//a[.='"+name+"']"));
        return name.equalsIgnoreCase(element.getText());
    }
}

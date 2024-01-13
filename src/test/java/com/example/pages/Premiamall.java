package com.example.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.time.Duration;
import java.util.List;

public class Premiamall {
    private WebDriver driver;

    public Premiamall( WebDriver driver){
        this.driver = driver;
    }

    public void searchProduct(String name){
        this.driver.findElement(By.xpath("//a[.=' Buscar ']")).click();
        WebElement element = this.driver.findElement(By.cssSelector("[data-placeholder='¿Qué buscás?']"));
        element.sendKeys(name);
        this.driver.findElement(By.cssSelector("[mattooltip='buscar']")).click();
    }

    public boolean verifyResultSearch(){
        this.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(7));
        List<WebElement> elements = this.driver.findElements(By.className("tarjeta-lista"));
        return elements.size()==16;
    }
}

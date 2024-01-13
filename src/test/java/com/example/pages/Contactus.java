package com.example.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Contactus {

    public static final String URL = "https://www.clubpromerica.com/costarica/contactus";
    private WebDriver driver;

    public Contactus(WebDriver driver){
        this.driver = driver;
    }

    public void fillFormContactus(String name,String email,String comment){
        this.driver.findElement(By.id("FullName")).sendKeys(name);
        this.driver.findElement(By.id("Email")).sendKeys(email);
        this.driver.findElement(By.id("Enquiry")).sendKeys(comment);
    }

    public void sendForm(){
        this.driver.findElement(By.name("send-email")).click();
    }

    public boolean isValidForm(){
        WebElement element = this.driver.findElement((By.cssSelector(".page-body .result")));
        String result = "Su comentario ha sido enviado con éxito al propietario de la tienda.";
        return result.equalsIgnoreCase(element.getText());
    }
}

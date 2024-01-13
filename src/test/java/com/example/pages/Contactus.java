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





    public void fillFormCheckout(String name,String email,String socialNumber,String phone){
        this.driver.findElement(By.xpath("//span[.='Name']//preceding-sibling::input[1]")).sendKeys(name);
        this.driver.findElement(By.xpath("//span[.='Email Address']//preceding-sibling::input[1]")).sendKeys(email);
        this.driver.findElement(By.xpath("//span[.='Social Security Number']//preceding-sibling::input[1]")).sendKeys(socialNumber);
        this.driver.findElement(By.xpath("//span[.='Phone Number']//preceding-sibling::input[1]")).sendKeys(phone);
    }

    public void uploadPhoto(String pathPhoto){
        this.driver.findElement(By.cssSelector("input[type='file']")).sendKeys(pathPhoto);
    }

    public void addPromotion(String codPromotion){
        this.driver.findElement(By.name("promo")).sendKeys(codPromotion);
        this.driver.findElement(By.xpath("//button[.='Apply']")).click();
    }

    public void selectPayNow(){
        this.driver.findElement(By.cssSelector("[data-react-toolbox='check']")).click();
        this.driver.findElement(By.xpath("//button[.='Pay now']")).click();
    }
}

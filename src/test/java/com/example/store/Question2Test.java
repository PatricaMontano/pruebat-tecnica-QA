package com.example.store;
import com.example.pages.Contactus;
import com.example.pages.Home;
import com.example.pages.Premiamall;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;


public class Question2Test {
    private WebDriver driver;
    public Home homepage;
    public Contactus contactus;
    public Premiamall premiamall;

    @Before
    public void setUp(){
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--lang=en-US");
        System.setProperty("webdriver.chrome.driver","./src/test/resources/chromedriver/chromedriver.exe");
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        homepage = new Home(this.driver);
        contactus = new Contactus(this.driver);
        premiamall = new Premiamall(this.driver);
    }

    @Test
    public void accessNavigation(){
        try {
            driver.get(Home.URL);
            this.homepage.scrollView(500);
            this.homepage.selectSubcategorie("Promociones y Descuentos");
            this.homepage.scrollView(500);
            Assert.assertTrue(this.homepage.verifyGridByName("Anímate a viajar por el mundo"));
        }catch (Exception e) {
            Assert.fail("Exception Test Acces and Navigation " + e);
        }
    }

    @Test
    public void interactionForm(){
        try {
            driver.get(Contactus.URL);
            this.contactus.fillFormContactus("Prueba Selenium","test@gmail.com","Comentario de prueba, ignorar");
            this.contactus.sendForm();
            Assert.assertTrue(this.contactus.isValidForm());

        }catch (Exception e) {
            Assert.fail("Exception Test Interaction and Fill Form" + e);
        }
    }


        @Test
    public void validationWeb(){
        try {
            driver.get(Home.URL);
            this.homepage.scrollView(500);
            this.homepage.selectSubcategorie(" Premia Mall");
            this.premiamall.searchProduct("juego");
            Assert.assertTrue(this.premiamall.verifyResultSearch());
        }catch (Exception e) {
            Assert.fail("Exception Test Validation" + e);
        }
    }


    @After
    public void cleanClose(){
        this.driver.quit();
    }

}

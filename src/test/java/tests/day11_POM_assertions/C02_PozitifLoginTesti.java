package tests.day11_POM_assertions;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.QdemyPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

public class C02_PozitifLoginTesti {

    @Test (groups = "smoke")
    public void pozitifLoginTesti() {

        // qd anasayfaya gidin
        Driver.getDriver().get(ConfigReader.getProperty("qdUrl"));

        // login linkine tıklayın
        QdemyPage qdemyPage = new QdemyPage();
        qdemyPage.ilkLoginLinki.click();

        // gecerli kullanici adi ve password ile giris yapin
        qdemyPage.emailKutusu.sendKeys(ConfigReader.getProperty("qdGecerliUsername"));
        qdemyPage.passwordKutusu.sendKeys(ConfigReader.getProperty("qdGecerliPassword"));
        // cookieyi kabul et
        Driver.getDriver().findElement(By.xpath("//a[@onclick='cookieAccept();']")).click();
        ReusableMethods.bekle(3);
        qdemyPage.loginButonu.click();

        // basarili bir sekilde giris yapıldığını test edin
        Assert.assertTrue(qdemyPage.basariliGirisElementi.isDisplayed());

        Driver.closeDriver();
    }
}

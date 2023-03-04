package tests.day12_xmlFiles;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.QdemyPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;
import utilities.TestBaseRapor;

public class C03_RaporluPozitifLoginTesti extends TestBaseRapor {

    @Test
    public void pozitifLoginTesti() {

        extentTest = extentReports.createTest("pozitif login testi", "basariyla giris yapildi");

        // qd anasayfaya gidin
        Driver.getDriver().get(ConfigReader.getProperty("qdUrl"));
        extentTest.info("anasayfaya gidildi");

        // login linkine tıklayın
        QdemyPage qdemyPage = new QdemyPage();
        qdemyPage.ilkLoginLinki.click();
        extentTest.info("ilk login linkine tıklandı");

        // gecerli kullanici adi ve password ile giris yapin
        qdemyPage.emailKutusu.sendKeys(ConfigReader.getProperty("qdGecerliUsername"));
        extentTest.info("geçerli email girildi");
        qdemyPage.passwordKutusu.sendKeys(ConfigReader.getProperty("qdGecerliPassword"));
        extentTest.info("geçerli password girildi");

        // cookieyi kabul edelim
        Driver.getDriver().findElement(By.xpath("//a[@onclick='cookieAccept();']")).click();
        ReusableMethods.bekle(2);
        qdemyPage.loginButonu.click();
        extentTest.info("login butonuna basıldı");

        // basarili bir sekilde giris yapıldığını test edin
        Assert.assertTrue(qdemyPage.basariliGirisElementi.isDisplayed());
        extentTest.pass("Başarılı şekilde giriş yapıldığı test edildi");


        Driver.closeDriver();
    }
}

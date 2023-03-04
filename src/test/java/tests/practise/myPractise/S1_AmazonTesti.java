package tests.practise.myPractise;

import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AmazonPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.TestBaseRapor;

import static pages.AmazonPage.aramaKutusu;

public class S1_AmazonTesti extends TestBaseRapor {
    // amazon sayfasina gidin
    // Test datasi olarak verilen kelime icin arama yapin
    // arama sonuclarinin arattigimiz test datasini icerdigini test edelim

    @Test
    public void amazonDataSearchTesti() {
        extentTest = extentReports.createTest("Amazon data search testi");
        // amazon sayfasina gidin
        Driver.getDriver().get(ConfigReader.getProperty("amazonUrl"));
        extentTest.info("Amazon anasayfaya gidildi");

        // Test datasi olarak verilen kelime icin arama yapin
        AmazonPage amazonPage = new AmazonPage();
        aramaKutusu.sendKeys(ConfigReader.getProperty("amazonAranacakKelime") + Keys.ENTER);
        extentTest.info("Aranacak kelime arama kutusuna girildi");

        // arama sonuclarinin arattigimiz test datasini icerdigini test edelim

        String actualAramaSonucu = amazonPage.aramaSonucElementi.getText();
        String expectedIcerik = ConfigReader.getProperty("amazonAranacakKelime");

        Assert.assertTrue(actualAramaSonucu.contains(expectedIcerik));
        extentTest.pass("Arama sonuçlarının aranan kelimeyi içerdiği doğrulandı");


    }
}


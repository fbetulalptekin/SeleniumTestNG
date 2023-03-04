package tests.day11_POM_assertions;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.QdemyPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

public class C03_NegatifLoginTesti {

    // qd anasayfaya gidin
    // 3 test method'u oluşturun ve asağıdaki durumlarda giriş yapılamadığını test edin
    // 1- gecerli username, gecersiz password
    // 2- gecersiz username, gecerli password
    // 3- gecersiz username, gecersiz password

    QdemyPage qdemyPage = new QdemyPage();

    @Test (groups = "smoke")
    public void negatifLogin1(){
        qdemyPage = new QdemyPage();
        Driver.getDriver().get(ConfigReader.getProperty("qdUrl"));
        qdemyPage.ilkLoginLinki.click();
        qdemyPage.emailKutusu.sendKeys(ConfigReader.getProperty("qdGecerliUsername"));
        qdemyPage.passwordKutusu.sendKeys(ConfigReader.getProperty("qdGecersizPassword"));
        ReusableMethods.bekle(2);
        // cookie
        Driver.getDriver().findElement(By.xpath("//a[@onclick='cookieAccept();']")).click();
        Driver.getDriver().navigate().refresh();
        qdemyPage.loginButonu.click();

        Assert.assertTrue(qdemyPage.emailKutusu.isEnabled());

        Driver.closeDriver();

    }

    @Test (groups = {"smoke","mr1"})
    public void negatifLogin2(){
        qdemyPage = new QdemyPage();
        Driver.getDriver().get(ConfigReader.getProperty("qdUrl"));
        qdemyPage.ilkLoginLinki.click();
        qdemyPage.emailKutusu.sendKeys(ConfigReader.getProperty("qdGecersizUsername"));
        qdemyPage.passwordKutusu.sendKeys(ConfigReader.getProperty("qdGecerliPassword"));
        // cookie
        Driver.getDriver().findElement(By.xpath("//a[@onclick='cookieAccept();']")).click();
        ReusableMethods.bekle(2);
        qdemyPage.loginButonu.click();

        Assert.assertTrue(qdemyPage.emailKutusu.isEnabled());

        Driver.closeDriver();

    }

    @Test
    public void negatifLogin3(){
        qdemyPage = new QdemyPage();
        Driver.getDriver().get(ConfigReader.getProperty("qdUrl"));
        qdemyPage.ilkLoginLinki.click();
        qdemyPage.emailKutusu.sendKeys(ConfigReader.getProperty("qdGecersizUsername"));
        qdemyPage.passwordKutusu.sendKeys(ConfigReader.getProperty("qdGecersizPassword"));
        // cookie
        Driver.getDriver().findElement(By.xpath("//a[@onclick='cookieAccept();']")).click();
        ReusableMethods.bekle(2);
        qdemyPage.loginButonu.click();

        Assert.assertTrue(qdemyPage.emailKutusu.isEnabled());

        Driver.closeDriver();

    }
}

package tests.day11_POM_assertions;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class C04_HardAssert_SoftAssert {

    @Test
    public void hardAssertionTesti() {

        Assert.assertTrue(5>8);

        Assert.assertFalse(8==8);

        Assert.assertEquals(5,8);

        Assert.assertNotEquals(6,6);
    }

    @Test
    public void softAssertionTesti() {
        /*
            JUnit'teki Assert class'ı TestNG'de de vardır
            Ancak bir test method'unda birden fazla failed olan assertion varsa
            ilk failed olan assertion'da çalışmayı durdurup exception fırlattığından
            tum hatayı bir defada gorup hepsini düzeltme şansımız olmaz

            TestNG bunun için bir alternatif oluşturmuş
            Bu alternatifte Assert class'ındaki static methodları kullanmak yerine

            SoftAssert class'ından bir obje oluşturup
            o obje üzerinden istediğimiz testleri yapıyoruz

            softassert objesi ile yapılan assertion'lar failed olsa da testimiz çalışmaya devam eder

            Ancak testlerin sonucunu görmek istediğimizde
            softassert.assertAll() ile tüm yaptığı testleri raporlamasını söyleyebiliriz

            assertAll() method'unun çalıştığı satırda
            exception olabilir
         */

        SoftAssert softAssert = new SoftAssert();

        softAssert.assertTrue(5>8,"true testi failed");

        softAssert.assertFalse(8==8, "false testi failed");

        softAssert.assertEquals(5,8, "equals testi failed");

        softAssert.assertNotEquals(6,6, "not equals testi failed");

        softAssert.assertAll();

        // java.lang.AssertionError: The following asserts failed:
        //	true testi failed expected [true] but found [false],
        //	false testi failed expected [false] but found [true],
        //	equals testi failed expected [8] but found [5],
        //	not equals testi failed did not expect [6] but found [6]
    }


}

package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import pages.BuyProduct;
import util.DriverFactory;

public class BuyProductSteps {

    WebDriver driver = DriverFactory.getDriver();
    BuyProduct buyProduct = new BuyProduct(driver);

    @Given("Hepsiburada web sayfası açılır")
    public void hepsiburadaWebSayfasıAçılır() {
        buyProduct.checkHomePage();
    }

    @When("Arama kısmına ürün adı {string} yazılır")
    public void aramaKısmınaÜrünAdıKıtapYazılır(String kitap) {
        buyProduct.typeSearchBookName(kitap);
    }

    @Then("İlk sıradaki ürün sepete eklenir")
    public void i̇lkSıradakiÜrünSepeteEklenir() throws InterruptedException {
        buyProduct.addCartFirstProduct();
    }

    @Then("İkinci sıradaki ürün sepete eklenir")
    public void i̇kinciSıradakiÜrünSepeteEklenir() throws InterruptedException {
        buyProduct.addCartSecondProduct();
    }

    @When("Sepetim ikonuna tıklanır")
    public void sepetimIkonunaTıklanır() throws InterruptedException {
        buyProduct.clickCartIcon();
    }

    @Then("Sepetteki ilk ürün {string} kontrol edilir")
    public void sepettekiIlkÜrünUrunKontrolEdilir(String urunbir) {
        buyProduct.checkFirstProduct(urunbir);
    }

    @Then("Sepetteki ikinci ürün {string} kontrol edilir")
    public void sepettekiIkinciÜrünUrunKontrolEdilir(String uruniki) {
        buyProduct.checkSecondProduct(uruniki);
    }

    @Then("Eposta adresi kısmına {string} yazar, giriş yap'a tıklar")
    public void epostaAdresiKısmınaEpostaYazarGirişYapATıklar(String eposta) throws InterruptedException {
        buyProduct.typeEmailClickLogin(eposta);
    }


    @Then("Sifre kısmına {string} yazar, giriş yap'a tıklar")
    public void sifreKısmınaSifreYazarGirişYapATıklar(String sifre) throws InterruptedException {
        buyProduct.typePasswordClickLogin(sifre);
    }

    @When("Kullanıcı alışverişi tamamla butonuna tıklar")
    public void kullanıcıAlışverişiTamamlaButonunaTıklar() {
        buyProduct.clickTamamlaBtn();
    }
}

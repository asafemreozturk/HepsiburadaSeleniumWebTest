
@BuyProduct
Feature: Buy Product

  @UyelikİleUrunEklemeKontrol
  Scenario Outline: Login olarak, Sepete Urun Ekleme, Eklenen Ürünü Kontrol Etme
    Given Hepsiburada web sayfası açılır
    When Arama kısmına ürün adı <kitap> yazılır
    Then İlk sıradaki ürün sepete eklenir
    Then İkinci sıradaki ürün sepete eklenir
    When Sepetim ikonuna tıklanır
    Then Sepetteki ilk ürün <urunbir> kontrol edilir
    Then Sepetteki ikinci ürün <uruniki> kontrol edilir
    When Kullanıcı alışverişi tamamla butonuna tıklar
    Then Eposta adresi kısmına <eposta> yazar, giriş yap'a tıklar
    Then Sifre kısmına <sifre> yazar, giriş yap'a tıklar

    Examples:
      | kitap  | urunbir | uruniki | eposta | sifre |
      |"robin hood" | "Robin Hood - Stage 3 - İngilizce Hikaye" | "Robin Hood - Howard Pyle" | "juda.toma@fallinhay.com" | "JudaToma123." |


  @UrunEklemeUrunKontrol
  Scenario Outline: Login olmadan, Sepete Urun Ekleme, Eklenen Ürünü Kontrol Etme
    Given Hepsiburada web sayfası açılır
    When Arama kısmına ürün adı <kitap> yazılır
    Then İlk sıradaki ürün sepete eklenir
    Then İkinci sıradaki ürün sepete eklenir
    When Sepetim ikonuna tıklanır
    Then Sepetteki ilk ürün <urunbir> kontrol edilir
    Then Sepetteki ikinci ürün <uruniki> kontrol edilir

    Examples:
      | kitap  | urunbir | uruniki |
      | "robin hood" | "Robin Hood - Stage 3 - İngilizce Hikaye" | "Robin Hood - Howard Pyle" |



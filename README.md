# Uygulama Dökümanı

Kullanici sistemde kayitli degil ise registration sayfasina gider ve kullanici adi, email ve sifre alanlarini doldurarak kaydini olusturur. Sonrasinda bu kayitli bilgiler ile tekrar sisteme giris yapabilir. 3 Adet ekranimiz vardir;

# Kullanici Kaydetme Ekrani

url ->  http://localhost:8080/registration
Kullanici bu ekrandaki inputlara bilgilerini girerek sisteme kaydini yapmis olacaktir. Tüm alanlarda validasyonlar vardir. Kullanici adi en az 3 karakter icermesi gerekmektedir. Email adresi gecerli bir email adresi olmak zorundadir. Kullanici sifresi ise en az 7 karakterli olup en az bir buyuk harf ve rakam icermesi gerekmektedir. Butun alanlarin girilmesi zorunludur. Form submit edildiginde validasyona uymayan girislerin hepsini gostermek yerine, sirasiyla tek tek gostermeyi tercih ettim. Kayit islemi basarili olduktan sonra hosgeldiniz ekranina yonlendirilecektir.

# Hosgeldiniz Ekrani

url ->  http://localhost:8080/welcome
Sisteme kaydini olusturmus yada sisteme login olmus kullanicilarin yonlendirildigi ekrandir. Bu ekranda tekrar logout olabilecekleri buton bulunmaktadir.

# Login Ekrani

url -> http://localhost:8080/login
Kullanicinin sistemde kayitli olan bilgileri ile sisteme giris yapabildigi ekranimizdir. Login islemi basarili olmasi halinde hosgeldiniz ekranina yonlendirilecektir.

# Projenin Build Edilmesi

Github’dan proje indirilir. Eclipce ve Sts icin File sekmesinden import secenegine tiklanir. Existing Maven Project secilir ve projeyi indirdigimiz path verilir. Pom.xml otomatik bulunur ve proje eklenmis olur. Intellij Idea icin ise File -> New -> Module From Existing Source sekmesine tiklanir ve projeyi indirdigimiz path verilir. Maven projesi olduğu algilanir ve pom.xml bulunur. Boylelikle projemiz eklenmis olur. Eclipce ve Sts idelerin debug configurations acilir. Yeni bir maven build olusturulur. Base directory’ye proje verilir. Goals inputuna ise jetty:run yazilir. Debug butonuna basilarak projesinin http://localhost:8080’ de build olmasi saglamis olur.

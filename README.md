# Randomize Algoritmalar: Monte Carlo Yaklaşımı ve İstatistiksel Analiz

Bu proje, büyük bir veri seti içerisindeki "özel" elemanları (belirli bir koşulu sağlayan sayılar) tespit etmek amacıyla geliştirilen **Monte Carlo** randomize algoritmasının deneysel bir ispatıdır. Çalışma kapsamında rastgeleliğin algoritma doğruluğu (hata payı) ve çalışma süresi (standart sapma) üzerindeki etkileri analiz edilmiştir.

## 📋 Ödev Parametreleri
Ödev gereksinimleri ve öğrenci numarası (**________44**) doğrultusunda belirlenen kriterler:

- **Algoritma Tipi:** Monte Carlo Yaklaşımı (Öğrenci no son rakamı çift: 4)
- **Veri Hacmi (n):** 100.000 ($10^5$) (Öğrenci no son rakamı < 5)
- **Seed (Tohum) Değeri:** 1240505044 (Deneyin tekrarlanabilirliği için)
- **Özel Koşul:** `x % 777 == 0` (777'ye tam bölünen elemanların tespiti)
- **İterasyon Sayısı (k):** 150

## 🚀 Algoritma Hakkında
### Monte Carlo Yaklaşımı
Monte Carlo algoritmaları, önceden belirlenmiş sabit bir iterasyon sayısında ($k$) çalışır. Bu durum algoritmanın çalışma süresini öngörülebilir ve sabit kılar ($O(k)$). Ancak, algoritma tüm veri setini taramadığı için sonucu bulamama (yanlış negatif) ihtimalini, yani istatistiksel bir hata payını göze alır.

### Las Vegas Algoritması ile Farkı
Las Vegas algoritmaları sonucu her zaman %100 doğru bulur ancak çalışma süresi şansa bağlı olarak değişkendir. Bu projede kullanılan Monte Carlo yöntemiyle, rastgeleliğin çalışma süresini değil, başarı olasılığını etkilediği deneysel olarak kanıtlanmıştır.

## 📊 Matematiksel Model
Algoritmanın hata yapma olasılığı aşağıdaki formül ile teorik olarak hesaplanmıştır:

$$P(\text{hata}) = (1 - p)^k$$

Burada:
- **p**: Dizideki gerçek "özel" eleman yoğunluğu.
- **k**: Yapılan rastgele örnekleme sayısı (150).

## 🛠️ Kurulum ve Çalıştırma
Proje Java programlama dili ile geliştirilmiştir.

1. Depoyu klonlayın:
   ```bash
   git clone https://github.com/kullaniciadi/Randomize-Algoritmalar-Monte-Carlo-Analizi.git

2.  Terminal veya komut satırı üzerinden derleyin:
    javac Main.java
3.  Algoritmayı çalıştırın:
    java Main

📈 Deneysel Sonuçlar

Algoritmanın 100 kez üst üste çalıştırılması sonucunda elde edilen veriler:

| Parametre                 | Değer                    |
| ------------------------- | ------------------------ |
| Gerçek Özel Eleman Sayısı |  99 (p: 9.9E-4)          |
| Teorik Hata Olasılığı     |  0,86194                 |
| Deneysel Hata Oranı       |  0,92000                 |
| Ortalama Çalışma Süresi   |  0,002789 ms             |
| Zaman Standart Sapması    |  0,001403 ms             |

# 💡 Sonuç

1.  Deneysel hata oranının teorik P(hata) hesabı ile büyük oranda örtüştüğü
    gözlemlenmiştir.
2.  Zaman standart sapmasının son derece düşük (sıfıra yakın) çıkması, Monte
    Carlo algoritmalarında rastgeleliğin çalışma süresi üzerinde bir belirsizlik
    yaratmadığını ispatlamıştır.

package Main;
import java.util.ArrayList;
import java.util.List;

public class KitapIslem {
    private List<KitapBilgileri> kitaplar = new ArrayList<>();
    private int mevcutKitapNo = 1; // Otomatik artan kitap numarası

    // Kitap Ekle
    public void kitapEkle(KitapBilgileri kitap) {
        kitap.setKitapNo(mevcutKitapNo++); // Kitaba benzersiz bir numara atanır
        kitaplar.add(kitap);
    }

    // Kitap Sil, kitap no'ya göre
    public void kitapSil(int kitapNo) {
        kitaplar.removeIf(kitap -> kitap.getkitapNo() == kitapNo);
    }

/*    // Kitap Bul, kitap no'ya göre
    public KitapBilgileri kitapBul(int kitapNo) {
        for (KitapBilgileri kitap : kitaplar) {
            if (kitap.getkitapNo() == kitapNo) {
                return kitap;
            }
        }
        return null;
    }*/

    // Kitap Bul, arama kriterine göre (ad, yazar, tür)
    public List<KitapBilgileri> kitapBul(String kriter) {
        List<KitapBilgileri> bulunanKitaplar = new ArrayList<>();
        for (KitapBilgileri kitap : kitaplar) {
            if (kitap.getKitapadi().toLowerCase().contains(kriter.toLowerCase()) ||
                    kitap.getYazar().toLowerCase().contains(kriter.toLowerCase()) ||
                    kitap.getTur().toLowerCase().contains(kriter.toLowerCase())) {
                bulunanKitaplar.add(kitap);
            }
        }
        return bulunanKitaplar;
    }


    public void KitapListele() {
        for (KitapBilgileri kitap : kitaplar) {
            System.out.println(kitap);
        }
    }

    // Kitap listesini döndürme
    public List<KitapBilgileri> getKitaplar() {
        return kitaplar;
    }
}


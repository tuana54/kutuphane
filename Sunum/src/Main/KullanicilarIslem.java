package Main;

import java.util.List;
import java.util.ArrayList;

public class KullanicilarIslem {
    private List<KullanicilarBilgisi> kullanicilar = new ArrayList<>();
    private int mevcutKullanici = 1; //otomatik artan kişi sayısı

    public void kullaniciEkle(KullanicilarBilgisi kullanici){
        kullanici.setKullaniciNo(mevcutKullanici++);
        kullanicilar.add(kullanici);
    }

    public KullanicilarBilgisi kullaniciSil(int kullaniciNo) {
        for (KullanicilarBilgisi kullanici : kullanicilar) {
            if (kullanici.getKullaniciNo() == kullaniciNo) {
                kullanicilar.remove(kullanici);
                return kullanici;
            }
        }
        return null;
    }

    public KullanicilarBilgisi kullaniciBul(double TcNo){
        for (KullanicilarBilgisi kullanici : kullanicilar){
            if(kullanici.getKimlikNo()==TcNo){
                return kullanici;
            }
        }
        return null;
    }

    public void kullaniciListele(){
        for (KullanicilarBilgisi kullanici : kullanicilar){
            System.out.println(kullanici);
        }
    }

    public List<KullanicilarBilgisi> getKullanicilar() {
        return kullanicilar;
    }
}


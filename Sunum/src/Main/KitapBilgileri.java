package Main;

public class KitapBilgileri {

    private int KitapNo;
    private String kitapadi;
    private String yazar;
    private int yayinyili;
    private String Tur;

    public KitapBilgileri(int kitapNo,String kitapadi,String yazar,int yayinyili,String Tur){
        this.KitapNo = kitapNo;
        this.kitapadi = kitapadi;
        this.yazar = yazar;
        this.yayinyili = yayinyili;
        this.Tur = Tur;
    }
    public void setKitapNo(int kitapNo1){
        this.KitapNo = kitapNo1;
    }
    public void setKitapadi(String kitapadi1){
        this.kitapadi = kitapadi1;
    }
    public void setYazar(String yazar1){
        this.yazar = yazar1;
    }
    public void setYayinyili(int yayinyili1){
        this.yayinyili = yayinyili1;
    }
    public void setTur(String tur){
        this.Tur = tur;
    }

    public int getkitapNo(){
        return KitapNo;
    }
    public String getKitapadi(){
        return kitapadi;
    }
    public String getYazar(){
        return yazar;
    }
    public int getYayinyili(){
        return yayinyili;
    }
    public String getTur(){
        return Tur;
    }

    public String toString() {
        return "Kitap No: " + KitapNo + ", Kitap Adı: " + kitapadi + ", Yazar: " + yazar +
                ", Yayın Yılı: " + yayinyili + ", Tür: " + Tur;
    }
}


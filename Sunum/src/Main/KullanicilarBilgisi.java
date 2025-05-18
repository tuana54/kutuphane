package Main;

public class KullanicilarBilgisi {
    private int kullaniciNo;
    private String firstName;
    private String lastName;
    private int yas;
    private String email;
    private long kimlikNo;


    public KullanicilarBilgisi(int kullaniciNo,String firstName,String lastName,int yas,String email,long kimlikNo){
        this.kullaniciNo=kullaniciNo;
        this.firstName = firstName;
        this.lastName = lastName;
        this.yas = yas;
        this.email = email;
        this.kimlikNo = kimlikNo;
    }
    public void setKullaniciNo(int kullaniciNo1){
        this.kullaniciNo = kullaniciNo1;
    }
    public void setFirstName(String firstName1){
        this.firstName = firstName1;
    }
    public void setLastName(String lastName1){
        this.lastName = lastName1;
    }
    public void setYas(int yas1){
        this.yas = yas1;
    }
    public void setEmail(String email1){
        this.email = email1;
    }
    public void setKimlikNo(long kimlikNo1){
        this.kimlikNo = kimlikNo1;
    }

    public int getKullaniciNo(){
        return kullaniciNo;
    }
    public String getFirstName(){
        return firstName;
    }
    public String getLastName(){
        return lastName;
    }
    public int getYas(){
        return yas;
    }
    public String getEmail(){
        return email;
    }
    public double getKimlikNo(){
        return kimlikNo;
    }

    public String toString(){
        return "Kullanici No : "+ kullaniciNo +" Adı : " + firstName + " Soyadı : "+ lastName +" Yaş : "+ yas +" E-mail : "+ email +" T.C Kimlik No : "+ kimlikNo;
    }
}

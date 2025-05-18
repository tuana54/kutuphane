package Main;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class Main {

    private static KitapIslem kitapIslem = new KitapIslem();
    private static KullanicilarIslem kullanicilarIslem = new KullanicilarIslem();

    public static void main(String[] args) {


        // Giriş ekranı oluşturma
        JFrame loginFrame = new JFrame("Kütüphane Girişi");
        loginFrame.getContentPane().setBackground(Color.WHITE);

        loginFrame.setSize(400, 400);
        loginFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        loginFrame.setLayout(null); // Layout'u manuel konumlandırmak için kaldırdık

        // Kullanıcı Adı Label ve TextField
        JLabel userLabel = new JLabel("Kullanıcı Adı:");
        userLabel.setBounds(100, 50, 100, 30); // x, y, genişlik, yükseklik
        JTextField userField = new JTextField();
        userField.setBounds(200, 50, 100, 30);

        // Şifre Label ve PasswordField
        JLabel passwordLabel = new JLabel("Şifre:");
        passwordLabel.setBounds(100, 100, 100, 30);
        JPasswordField passwordField = new JPasswordField();
        passwordField.setBounds(200, 100, 100, 30);

        // Giriş Butonu
        JButton loginButton = new JButton("Giriş Yap");
        loginButton.setBounds(150, 150, 100, 30);

        // Bileşenleri Frame'e ekle
        loginFrame.add(userLabel);
        loginFrame.add(userField);
        loginFrame.add(passwordLabel);
        loginFrame.add(passwordField);
        loginFrame.add(loginButton);

        // Buton olay dinleyicisi
        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String kullaniciAdi = userField.getText();
                String sifre = new String(passwordField.getPassword());

                // Gerçek bir uygulamada burası veritabanından kontrol edilir
                String adminKullaniciAdi = "admin";
                String adminSifre = "1234";

                if (kullaniciAdi.equals(adminKullaniciAdi) && sifre.equals(adminSifre)) {
                    loginFrame.setVisible(false);
                    anaMenu();
                } else {
                    JOptionPane.showMessageDialog(null, "Hatalı kullanıcı adı veya şifre.", "Hata", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        loginFrame.setVisible(true);
    }

        // Giriş başarılıysa ana menü başlatılır
       // anaMenu();
    //}

    private static void anaMenu() {

        // Örnek kitaplar ve kullanıcılar ekleniyor
        kitapIslem.kitapEkle(new KitapBilgileri(1, "Yüzüklerin Efendisi", "J.R.R Tolkien", 1954, "Fantastik"));
        kitapIslem.kitapEkle(new KitapBilgileri(2, "Suç ve Ceza", "Dostoyevski", 1867, "Psikoloji"));
        kitapIslem.kitapEkle(new KitapBilgileri(3, "Sefiller", "Victor Hugo", 1862, "Epik"));
        kitapIslem.kitapEkle(new KitapBilgileri(4, "Küçük Prens", "Antoine de Saint-Exupery", 1943, "Uzun Hikaye"));

        kullanicilarIslem.kullaniciEkle(new KullanicilarBilgisi(0, "Muhammed", "Canpolat", 21, "muhammed@kutuphane.com", 12345678912L));
        kullanicilarIslem.kullaniciEkle(new KullanicilarBilgisi(0, "Asude", "Taşdemir", 22, "asude@kutuphane.com", 32168431351L));
        kullanicilarIslem.kullaniciEkle(new KullanicilarBilgisi(0, "Dilara", "Karaca", 21, "dilara@kutuphane.com", 45168162151L));
        kullanicilarIslem.kullaniciEkle(new KullanicilarBilgisi(0, "Anıl", "Güler", 23, "anıl@kutuphane.com", 35498112184L));

        // Ana pencere
        JFrame frame = new JFrame("Kütüphane Yönetim Sistemi");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 500);

        // Ana panel
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(0, 1, 10, 10));

        JButton btnListBooks = new JButton("Kitapları Listele");
        JButton btnFindBooks = new JButton("Kitap Bul");
        JButton btnAddBook = new JButton("Kitap Ekle");
        JButton btnDeleteBook = new JButton("Kitap Sil");
        JButton btnListPerson = new JButton("Kayıtlı Kullanıcıları Görüntüle");
        JButton btnAddPerson = new JButton("Kullanıcı Ekle");
        JButton btnDeletePerson = new JButton("Kullanıcı Sil");
        JButton btnExit = new JButton("Çıkış");

        panel.add(btnListBooks);
        panel.add(btnFindBooks);
        panel.add(btnAddBook);
        panel.add(btnDeleteBook);
        panel.add(btnListPerson);
        panel.add(btnAddPerson);
        panel.add(btnDeletePerson);
        panel.add(btnExit);

        frame.add(panel);

        // Kitapları Listele Butonu
        btnListBooks.addActionListener((ActionEvent e) -> {
            StringBuilder kitapListesi = new StringBuilder();
            for (KitapBilgileri kitap : kitapIslem.getKitaplar()) {
                kitapListesi.append(kitap).append("\n");
            }
            JOptionPane.showMessageDialog(frame, kitapListesi.length() > 0 ? kitapListesi.toString() : "Hiç kitap yok.", "Kitap Listesi", JOptionPane.INFORMATION_MESSAGE);
        });

        // Kitap Bul Butonu+
        btnFindBooks.addActionListener((ActionEvent e) -> {
            String aramaKriteri = JOptionPane.showInputDialog(frame, "Arama kriteri (ad, yazar, tür):");
            if (aramaKriteri != null && !aramaKriteri.trim().isEmpty()) {
                List<KitapBilgileri> bulunanKitaplar = kitapIslem.kitapBul(aramaKriteri);

                StringBuilder kitapListesi = new StringBuilder();
                for (KitapBilgileri kitap : bulunanKitaplar) {
                    kitapListesi.append(kitap).append("\n");
                }
                JOptionPane.showMessageDialog(frame, kitapListesi.length() > 0 ? kitapListesi.toString() : "Kitap bulunamadı.", "Kitap Arama Sonuçları", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(frame, "Arama kriteri boş olamaz.", "Hata", JOptionPane.ERROR_MESSAGE);
            }
        });

        // Kitap Ekle Butonu
        btnAddBook.addActionListener((ActionEvent e) -> {
            JTextField txtName = new JTextField();
            JTextField txtAuthor = new JTextField();
            JTextField txtYear = new JTextField();
            JTextField txtGenre = new JTextField();

            Object[] fields = {
                    "Kitap Adı:", txtName,
                    "Yazar:", txtAuthor,
                    "Yayın Yılı:", txtYear,
                    "Tür:", txtGenre
            };

            int result = JOptionPane.showConfirmDialog(frame, fields, "Kitap Ekle", JOptionPane.OK_CANCEL_OPTION);

            if (result == JOptionPane.OK_OPTION) {
                String name = txtName.getText();
                String author = txtAuthor.getText();
                int year = Integer.parseInt(txtYear.getText());
                String genre = txtGenre.getText();

                KitapBilgileri yeniKitap = new KitapBilgileri(0, name, author, year, genre);
                kitapIslem.kitapEkle(yeniKitap);
                JOptionPane.showMessageDialog(frame, "Kitap başarıyla eklendi!", "Başarılı", JOptionPane.INFORMATION_MESSAGE);
            }
        });

        // Kitap Sil Butonu
        btnDeleteBook.addActionListener((ActionEvent e) -> {
            String kitapIdString = JOptionPane.showInputDialog(frame, "Silmek istediğiniz kitabın ID'si:");
            try {
                int kitapId = Integer.parseInt(kitapIdString);
                kitapIslem.kitapSil(kitapId);
                JOptionPane.showMessageDialog(frame, "Kitap başarıyla silindi.", "Başarılı", JOptionPane.INFORMATION_MESSAGE);
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(frame, "Geçersiz kitap ID'si.", "Hata", JOptionPane.ERROR_MESSAGE);
            }
        });

        // Kayıtlı Kullanıcıları Görüntüle Butonu
        btnListPerson.addActionListener((ActionEvent e) -> {
            StringBuilder kullaniciListesi = new StringBuilder();
            for (KullanicilarBilgisi kullanici : kullanicilarIslem.getKullanicilar()) {
                kullaniciListesi.append(kullanici).append("\n");
            }
            JOptionPane.showMessageDialog(frame, kullaniciListesi.length() > 0 ? kullaniciListesi.toString() : "Hiç kullanıcı yok.", "Kullanıcı Listesi", JOptionPane.INFORMATION_MESSAGE);
        });

        // Kullanıcı Ekle Butonu
        btnAddPerson.addActionListener((ActionEvent e) -> {
            JTextField txtFirstName = new JTextField();
            JTextField txtLastName = new JTextField();
            JTextField txtAge = new JTextField();
            JTextField txtEmail = new JTextField();
            JTextField txtKimlikNo = new JTextField();

            Object[] fields = {
                    "Ad:", txtFirstName,
                    "Soyad:", txtLastName,
                    "Yaş:", txtAge,
                    "Email:", txtEmail,
                    "T.C. Kimlik No:", txtKimlikNo
            };

            int result = JOptionPane.showConfirmDialog(frame, fields, "Kullanıcı Ekle", JOptionPane.OK_CANCEL_OPTION);

            if (result == JOptionPane.OK_OPTION) {
                String firstName = txtFirstName.getText();
                String lastName = txtLastName.getText();
                int age = Integer.parseInt(txtAge.getText());
                String email = txtEmail.getText();
                long kimlikNo = Long.parseLong(txtKimlikNo.getText());

                KullanicilarBilgisi yeniKullanici = new KullanicilarBilgisi(0, firstName, lastName, age, email, kimlikNo);
                kullanicilarIslem.kullaniciEkle(yeniKullanici);
                JOptionPane.showMessageDialog(frame, "Kullanıcı başarıyla eklendi!", "Başarılı", JOptionPane.INFORMATION_MESSAGE);
            }
        });

        // Kullanıcı Sil Butonu
        btnDeletePerson.addActionListener((ActionEvent e) -> {
            String kullaniciIdString = JOptionPane.showInputDialog(frame, "Silmek istediğiniz kullanıcının ID'si:");
            try {
                int kullaniciId = Integer.parseInt(kullaniciIdString);
                KullanicilarBilgisi silinenKullanici = kullanicilarIslem.kullaniciSil(kullaniciId);
                if (silinenKullanici != null) {
                    JOptionPane.showMessageDialog(frame, "Kullanıcı başarıyla silindi: " + silinenKullanici, "Başarılı", JOptionPane.INFORMATION_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(frame, "Belirtilen ID'ye sahip kullanıcı bulunamadı.", "Hata", JOptionPane.ERROR_MESSAGE);
                }
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(frame, "Geçersiz kullanıcı ID'si.", "Hata", JOptionPane.ERROR_MESSAGE);
            }
        });

        // Çıkış Butonu
        btnExit.addActionListener(e -> System.exit(0));

        frame.setVisible(true);
    }
}

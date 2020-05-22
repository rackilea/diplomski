import java.sql.Connection;
import java.sql.Statement;
...
public void actionPerformed(ActionEvent arg0) throws SQLException, ClassNotFoundException {
        Class.forName("com.mysql.jdbc.Driver");

        Connection baglanti = DriverManager.getConnection("jdbc:mysql://localhost:3306/iscikayit", "root", "");

        Statement ifade = baglanti.createStatement();
        String tc = textField.getText();
        String ad = textField_1.getText();
        String soyad = textField_2.getText();
        String telno = textField_3.getText();
        String eposta = textField_4.getText();
        String egitim = comboBox.getName();
        String adres = textArea.getText();
        String cinsiyet = comboBox_2.getName();
        String askerlik = comboBox_1.getName();
        String ehliyet = comboBox_3.getName();
        ifade.executeUpdate("insert into isci(tc,ad,soyad,telno,eposta,egitim,adres,cinsiyet,askerlik,ehliyet)"
                +
                " values('"
                + tc
                + "','"
                + ad
                + "','"
                + soyad
                + "','"
                + telno
                + "','"
                + eposta
                + "','"
                + egitim
                + "','"
                + adres
                + "','"
                + cinsiyet
                + "','"
                + askerlik
                + "','"
                + ehliyet + "')");
    }
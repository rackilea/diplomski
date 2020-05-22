ResultSet rss1=st.executeQuery(sql);
boolean hasResults = rss1.next()
if (hasResults && pilih1.getSelectedItem().toString().equals("Pasien")) {
    pasien1 = new pasien1();
    pasien1.setVisible(true);
    this.dispose();
    System.out.println("haha");
}
else if (hasResults && pilih1.getSelectedItem().toString().equals("Dokter")) {
    dokter1 = new dokter1();
    dokter1.setVisible(true);
    this.dispose();
}
else if (hasResults && pilih1.getSelectedItem().toString().equals("Staff")){
    staff1 = new staff1();
    staff1.setVisible(true);
    this.dispose();
}
else{
    JOptionPane.showMessageDialog(null, "Gagal Login");
}
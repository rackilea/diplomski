public void actionPerformed(ActionEvent e) {
    Preis = Preis + gemüsepreis;
    labelsumme.setText(String.valueOf(Preis));
    while (kunde == 1) {     
        T gemüicon = iconsMap.get(brgemü++);
        gemüicon.setVisible(false);
        Bestellpanel.add(gemüicon);
        gemüicon.setVisible(true);
        return; 
    }
}
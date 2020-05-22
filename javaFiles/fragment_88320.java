class StackOverflow {
    PreparedStatement preparedStatement;
    Label jNaam;
    TextField lNaam;
    Label jEmail;
    TextField lEmail;
    Label jAdres;
    TextField lAdres;
    Label jPlaats;
    TextField lPlaats;
    Label jPostcode;
    TextField lPostcode;
    Label jTelefoon;
    TextField lTelefoon;
    Label jBedrijfsNaam;
    TextField lBedrijfsNaam;

public StackOverflow() {
    initGui();
}

private void initGui() {
    jNaam = new Label("Naam");
    lNaam = new TextField(30);
    jEmail = new Label("E-Mail");
    lEmail = new TextField(30);
    jAdres = new Label("Adres");
    lAdres = new TextField(30);
    jPlaats = new Label("Plaats");
    lPlaats = new TextField(100);
    jPostcode = new Label("Postcode");
    lPostcode = new TextField(6);
    jTelefoon = new Label("Telefoon");
    lTelefoon = new TextField(13);
    jBedrijfsNaam = new Label("Bedrijfsnaam");
    lBedrijfsNaam = new TextField(30);

    JButton save = new JButton("save");
    save.addActionListener(new ActionListener() {

        @Override
        public void actionPerformed(ActionEvent e) {
            pushData();

        }
    });
}

private void pushData() {
    try {
        preparedStatement.setString(1, lNaam.getText());
        preparedStatement.setString(2, lEmail.getText());
        preparedStatement.setString(3, lAdres.getText());
        preparedStatement.setString(4, lPlaats.getText());
        preparedStatement.setString(5, lPostcode.getText());
        preparedStatement.setString(6, lTelefoon.getText());
        preparedStatement.setString(7, lBedrijfsNaam.getText());
        preparedStatement.executeUpdate();
    } catch (SQLException e) {
        e.printStackTrace();
    }

}
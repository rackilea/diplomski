> public void initialize(URL url, ResourceBundle rb) {
    >        nom.setCellFactory(TextFieldTableCell.<User>forTableColumn());
    >        prenom.setCellFactory(TextFieldTableCell.<User>forTableColumn());
    >        cin.setCellFactory(TextFieldTableCell.<User>forTableColumn());
    >        dn.setCellFactory(TextFieldTableCell.<User>forTableColumn());
    >        adresse.setCellFactory(TextFieldTableCell.<User>forTableColumn());
    >        tel.setCellFactory(TextFieldTableCell.<User>forTableColumn());
    >     }
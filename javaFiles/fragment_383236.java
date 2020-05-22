public OefeningToevoegenSchermController(DomeinController controller) {
    this.controller = controller;
    groepsbewerkingen = new ArrayList<>();


    FXMLLoader loader = new FXMLLoader(getClass().getResource("OefeningToevoegenScherm.fxml"));        

    loader.setRoot(this);
    loader.setController(this);

    try {
        loader.load();
        opgaveLbl.setVisible(false);
        feedbackLbl.setVisible(false);        

        System.out.println(controller.geefGroepsBewerkingen());

        groepsbewerkingenListView.setItems(controller.geefGroepsBewerkingen());
    } catch (IOException ex) {
        throw new RuntimeException(ex);
    }

}
tcPloeg.setCellFactory(tc -> new TableCell<PersoonBag, PloegBag>() {
    @Override
    public void updateItem(PloegBag ploeg, boolean empty) {
        if (empty || ploeg == null) {
            setText(null);
        } else {
            setText(ploeg.getNaam());
        }
    }
});
runColumn.setCellValueFactory(new PropertyValueFactory<Patch, String>("btnText"));
runColumn.setCellFactory(column -> new TableCell<Patch, String>() {
    Button btn = new Button();

    {
        btn.setOnAction(e -> {
            Patch pt = getTableView().getItems().get(getIndex());
            btn.setDisable(true);
            Tooltip tool = new Tooltip("Running");
            setTooltip(tool);
            System.out.println("ruleaza");
            try {
                SmbFile script = new SmbFile(path + pt.getDenumire(), userCred);

            } catch (MalformedURLException e1) {
                // TODO Auto-generated catch block
                e1.printStackTrace();
            }
            try {

                SmbFile smbFromFile = new SmbFile(path + pt.getDenumire(), userCred);
                SmbFile smbToFile = new SmbFile(path + "Aplicate/" + pt.getDenumire(), userCred);
                smbFromFile.renameTo(smbToFile);
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        });
    }

    @Override
    protected void updateItem(String item, boolean empty) {
        super.updateItem(item, empty);
        if (item == null) {
            setGraphic(null);
        } else {
            btn.setText(item);
            setGraphic(btn);
        }
    }
});
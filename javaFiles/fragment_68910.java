private Task<List<Row>> updateContactTableTask ;

// ...

private void showPersonDetails(Person person) {

    contactoTable.getItems().clear();

    firstNameLabel.setText(person.getFirstName());
    lastNameLabel.setText(person.getLastName());
    mailLabel.setText(person.getMail());
    phoneLabel.setText(person.getPhone());
    descriptionLabel.setText(person.getDescription());


    if (updateContactTableTask != null && updateContactTableTask.isRunning()) {
        updateContactTableTask.cancel();
    }

    updateContactTableTask = new Task<List<Row>>() {
        @Override
        protected List<Row> call() throws Exception {

            List<Row> resultList = new ArrayList<>() ;

            //Background work 
            DBManager db = new DBManager();
            String query = "SELECT * FROM eventos";
            ResultSet r = db.executeSelect(query);

            // quit if we got canceled here...
            if (isCancelled()) {
                return resultList;
            }

            while (r.next() && ! isCancelled()) {

                // Note: building a query like this is inherently unsafe
                // You should use a PreparedStatement in your DBManager class instead
                String q = "SELECT * FROM " + r.getString("Nombre").replace(" ", "_") + " WHERE Nombre = '" + person.getFirstName() + "' AND Apellidos = '" + person.getLastName() + "' AND Correo = '" + person.getMail() + "'";
                ResultSet result = db.executeSelect(q);

                while (result.next()) {
                    resultList.add(new Row(r.getString("Nombre"), result.getString("Asistencia")));
                }

            }

            return resultList ;
        }
    };

    updateContactTableTask.setOnSucceeded(e -> {
        // not really clear you still need contactoData, but if you do:
        contactoData.setAll(updateContactTableTask.getValue());
        contactoTable.setPlaceholder(new Label("No invitado a ningún evento"));
        contactoTable.setItems(contactoData);
    });

    updateContactTableTask.setOnFailed(e -> {
        // handle database errors here...
    });

    new Thread(updateContactTableTask).start();
}
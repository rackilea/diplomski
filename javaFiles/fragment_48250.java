FilteredList<CommandeFX> filteredData = new FilteredList<>(data, p -> true);

// 2. Set the filter Predicate whenever the filter changes.
filterField.textProperty().addListener((observable, oldValue, newValue) -> {
    filteredData.setPredicate(commande -> {
        // If filter text is empty, display all persons.
        if (newValue == null || newValue.isEmpty()) {
            return true;
        }

        // Compare first name and last name of every person with filter text.
        String lowerCaseFilter = newValue.toLowerCase();

        if (String.valueOf(commande.getCodeCommande()).toLowerCase().contains(lowerCaseFilter)) {
            return true;
             // Filter matches first name.

        } else if (String.valueOf(commande.getCMD()).toLowerCase().contains(lowerCaseFilter)) {
            return true; // Filter matches last name.
        }
        else if (String.valueOf(commande.getClient()).toLowerCase().contains(lowerCaseFilter)) {                                  
            return true; // Filter matches last name.
        }
        else if (String.valueOf(commande.getFournisseur()).toLowerCase().contains(lowerCaseFilter)) {
            return true; // Filter matches last name.
        }
        else if (String.valueOf(commande.getQuantite()).toLowerCase().contains(lowerCaseFilter)) {
            return true; // Filter matches last name.
        }
        else if (String.valueOf(commande.getPrixCommande()).toLowerCase().contains(lowerCaseFilter)) {
            return true; // Filter matches last name.
        }
        else if (String.valueOf(commande.getSommeProperty()).toLowerCase().contains(lowerCaseFilter)) {
            return true; // Filter matches last name.
        }
        else if (String.valueOf(commande.getResteCommandeProperty()).toLowerCase().contains(lowerCaseFilter)) {
            return true; // Filter matches last name.
        }
        else if (String.valueOf(commande.getDateCommande()).toLowerCase().contains(lowerCaseFilter)) {
            return true; // Filter matches last name.
        }
        else if (String.valueOf(commande.getDateReception()).toLowerCase().contains(lowerCaseFilter)) {
            return true; // Filter matches last name.
        }
        else if (String.valueOf(commande.getModified()).toLowerCase().contains(lowerCaseFilter)) {
            return true; // Filter matches last name.
        }
        else if (String.valueOf(commande.getValide()).toLowerCase().contains(lowerCaseFilter)) {
            return true; // Filter matches last name.
        }

        return false; // Does not match.
    });



      // 3. Wrap the FilteredList in a SortedList. 
      SortedList<CommandeFX> sortedData = new SortedList<>(filteredData);    

      // 4. Bind the SortedList comparator to the TableView comparator.
  sortedData.comparatorProperty().bind(tableCommandes.comparatorProperty());
     // 5. Add sorted (and filtered) data to the table.
     tableCommandes.setItems(sortedData);
     // the function 
     setSum(sortedData);

});
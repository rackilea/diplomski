@FXML
    void edit_colnom(TableColumn.CellEditEvent<User, String> event) throws SQLException {
        User u= event.getRowValue();
        u.modifier_user("nom",event.getNewValue(), u.getId());      
    }

    @FXML
    void edit_colprenom(TableColumn.CellEditEvent<User, String> event) throws SQLException {
        User u= event.getRowValue();
        u.modifier_user("prenom",event.getNewValue(), u.getId());  
    }

    @FXML
    void edit_coltele(TableColumn.CellEditEvent<User, String> event) throws SQLException {
        User u= event.getRowValue();
        u.modifier_user("tele",event.getNewValue(), u.getId());  
    }


    @FXML
    void edit_coladresse(TableColumn.CellEditEvent<User, String> event) throws SQLException {
        User u= event.getRowValue();
        u.modifier_user("adresse",event.getNewValue(), u.getId());  
    }

    @FXML
    void edit_colcin(TableColumn.CellEditEvent<User, String> event) throws SQLException {
        User u= event.getRowValue();
        u.modifier_user("cin",event.getNewValue(), u.getId());  
    }

    @FXML
    void edit_coldn(TableColumn.CellEditEvent<User, String> event) throws SQLException {
        User u= event.getRowValue();
        u.modifier_user("dn",event.getNewValue(), u.getId());  
    }
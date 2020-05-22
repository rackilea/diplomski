SQLQuery query=session.createSQLQuery ("UPDATE uposlenik SET ime=?,prezime=?,adresa=?,plata=? WHERE id= ?");
        query.setString(0, jText_Ime.getText());
        query.setString(1, jText_Prezime.getText());
        query.setString(2, jText_Adresa.getText()); 
        query.setString(3, jText_Plata.getText()); 
        query.setString(4, jText_id.getText());
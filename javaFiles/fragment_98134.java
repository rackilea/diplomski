public boolean create(Vehicule v) {
        String query = "INSERT INTO vehicule (MARQUE, MOTEUR, PRIX, NOM) VALUES (";
        query += v.getMarque().getId() + ", " + v.getMoteur().getId() + ", "
                + v.getPrix() + ", \'" + v.getNom() + "\')";

        try {
            connect.setAutoCommit(false);
            ResultSet nextID = connect.prepareStatement(
                    "CALL NEXT VALUE FOR seq_vehicule_id").executeQuery();
            if (nextID.next()) {
                int ID = nextID.getInt(1);
                v.setId(ID - 1);
            }

            /* Save vehicle */
            Statement state = this.connect.createStatement();
            state.executeUpdate(query);

            /* Now start with creating query for vehicle_option. Execute only if collection not empty */
            if (!v.getOptions().isEmpty()) {
                query = "INSERT INTO vehicule_option (id_vehicule, id_option) VALUES ";
                boolean valueAdded = false;
                for (Option o : v.getOptions()) {
                    System.out.println(v.getId() + " " + o.getId());
                    if (valueAdded) {
                        query += ", ";
                    }
                    query += "(" + v.getId() + ", " + o.getId() + ")";
                    valueAdded = true;
                }

                state = this.connect.createStatement();
                state.executeUpdate(query);
            }
            /* Commit inserts if all queries executed fine */
            connect.commit();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return true;
    }
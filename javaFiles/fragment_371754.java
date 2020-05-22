String updateTableSQL = "UPDATE Player SET  firstName = ?, lastName = ?, parentsName= ?, phoneNumber= ?, email = ?, amountPaid = ? WHERE id = ?";


                    try {
                        dbConnection = getDBConnection();
                        preparedStatement = dbConnection.prepareStatement(updateTableSQL);

                        preparedStatement.setString(1, players.getFirstName());
                        preparedStatement.setString(2, players.getLastName());
                        preparedStatement.setString(3, players.getParentsName());
                        preparedStatement.setInt(4, players.getPhoneNumber());
                        preparedStatement.setString(5, players.getEmail());
                        preparedStatement.setInt(6, players.getAmountPaid());
                     preparedStatement.setInt(7,players.getRegistrationId());
                        // execute update SQL stetement
                        preparedStatement.executeUpdate();

                        System.out.println("Record is updated to DBUSER table!");

                    } catch (SQLException e) {

                        System.out.println(e.getMessage());

                    }
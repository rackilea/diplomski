PreparedStatement upd = sql.prepareStatement("INSERT INTO address(houseNumber, street, district, city, postcode) VALUES (?, ?, ?, ?, ?)");
upd.setInt(1, address.getHouseNumber());
upd.setString(2, address.getStreet());
... // Set other fields
upd.executeUpdate();
sql.commit();
String query = "Update Book set name = ?, type=? where id =?";

try (PreparedStatement update = connection.prepareStatement(query)) {

    update.setString(1, txtName.getText());
    update.setString(2, txtType.getText());
    update.setInt(3, id);

    update.executeUpdate();
}
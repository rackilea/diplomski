public void caller() {
     ArrayList<String> players = null;
     try {
          players = database.LoadUsers();
     } catch (SQLException e) {
          e.printStackTrace();
     }
}
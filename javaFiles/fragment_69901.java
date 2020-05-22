List<Movie> movies = new ArrayList<>();

try(PreparedStatement stmt= con.prepareStament("select * from movies where genre=?")) {
  stmt.setString(1, Genere);
  try(ResultSet rs = stmt.executeQuery()) {
    while(rs.next()){
      String name=rs.getString("name");
      String genre=rs.getString("genre");
      int year=rs.getInt("year");
      int metascore=rs.getInt("metascore");
      movies.add(new Movie(name,genre,year,metascore));
    }
  }
}
return movies;
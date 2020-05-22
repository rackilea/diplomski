while(rs.next()){
   ArrayList<String> movs = new ArrayList<String>();

   movs.add(rs.getString("movie_id"));
   movs.add(rs.getString("movie_name"));
   movs.add(rs.getString("description"));
   movies.add(movs);
   for(ArrayList<String> ls : movies) {
        System.out.println(Arrays.deepToString(ls.toArray()));
   }
}
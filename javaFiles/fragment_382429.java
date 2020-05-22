public final class Mapper {

   public static service.Movie from(database.Movie dMovie) {
      service.Movie movie = new service.Movie();
      // set the properties based on database.Movie
      return movie;
   }
}
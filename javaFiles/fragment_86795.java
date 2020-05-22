public interface RestaurantRepository extends CrudRepository<Restaurant, Integer> {

    @Query("select distinct r from Restaurant r inner join r.meals m where m.date =:date")
    List<Restaurant> findByRestaurantMealDate(@Param("date") LocalDate date);

}
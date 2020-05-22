public interface CatDto {
    Long getId();
    String getName();
}

public interface CatRepo extends CrudRepository<Cat,Long> {

    //...
    @Query("select c.id as id, c.name as name from Cat c")
    public List<CatDto> getCatDtos(); 
}
public interface CatRepo extends CrudRepository<Cat,Long> {

    //...
    @Query("select new ...CatDto(c.id, c.name) from Cat c")
    public List<CatDto> getCatDtos(); 
}
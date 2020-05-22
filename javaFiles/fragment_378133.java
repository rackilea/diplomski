public interface TesztRepo extends Repository<Teszt, Teszt>
{
  @Query( value="select * from teszt"
        , nativeQuery = true
        )
  List<Teszt> sokasag();
//...
}
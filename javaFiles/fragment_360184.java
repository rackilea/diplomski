@Mapper
public interface PersonMapper {

    @InsertProvider(type = PersonProvider.class, method = "insertPerson")
    void insertPerson(@Param("person") Person person);

    @InsertProvider(type = PersonProvider.class, method = "insertPersonInterest")
    void insertInterestItem(@Param("interest") Interest item);
}

@Component
public class PersonProvider {
    public String insertPersonInterest() {
        return  "insert into person_interest (...) " +
                "values (#{...}, ...);";
    }
    public String insertPerson() {
        return  "insert into person (...) " +
                "values (#{...}, ...);";
    }
}
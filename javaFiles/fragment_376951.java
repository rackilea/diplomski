@Component
public class Test {

    @Authorised(id = "{personId}")
    public void test(PersonId personId) {
        System.out.println("component " + personId.getId()); //gets personId
    }
}
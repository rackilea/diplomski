public class PersonProxy {

    // JPA provider sets up this field when you call getReference
    private Integer personId;

    private String query = "UPDATE PERSON SET ";

    private boolean stateChanged = false;

    public void setAge(Integer newAge) {
        stateChanged = true;

        query += query + "AGE = " + newAge;
    }

}
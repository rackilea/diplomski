public interface PersonProjection {
    String getFirstName();
    String getLastName();
}

@Query("select p.firstName as firstName, p.lastName as lastName from Person p")
List<PersonProjection> getAllPersonProjections();
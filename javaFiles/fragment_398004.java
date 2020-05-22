public interface PersonProjection {
    String getLastName();
}

@Query("select p.lastName as lastName from Person p")
List<PersonProjection> getAllPersonProjections();
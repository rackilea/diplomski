public class JpaMovie {

    @OneToMany
    private List<Actor> actors;

    // Whatever you need in JPA DAL.
}

public class GraphMovie {
    // Whatever you need in Graph DAL.
}

public class MovieDTO {
    // Structure of the web service response.
    // Always convert to this type before returning.
    // This way, no matter the DAL, your response
    // structure will always be the same.
}
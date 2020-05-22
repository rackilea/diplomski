@Entity
@Table(name = "Questions")
public final class Question {

    private static class ModelConstraints {
        static final int MAX_BODY_LENGTH = 1024;
        // limits for other fields are going here
    }

    private static final Map<String, Integer> modelConstraintsMap;

    static
    {
        final Map<String, Integer> localConstraintsMap = new HashMap<>();
        localConstraintsMap.put("MAX_BODY_LENGTH", ModelConstraints.MAX_BODY_LENGTH);
        // .... putting all constants from ModelConstraints to the map here

        // composing unmodifable map    
        modelConstraintsMap = Collections.unmodifiableMap(localConstraintsMap);
    }

    @Column(length = ModelConstraints.MAX_BODY_LENGTH, nullable = false)
    @Size(max = ModelConstraints.MAX_BODY_LENGTH)
    private String body;

    // other properties and code

    public static Map<String, Integer> getModelConstraintsMap() {
        return modelConstraintsMap;
    }   

    // other properties and code
}
// Person table has only Person details 
public class Person {
    private Long id;
    private String name;
}

// Role table has only Role details 
public class Role {
    private Long id;
    private String name; //like manager, goalkeeping_coach, player
}

// Position table has only ... 
public class Position {
    private Long id;
    private String name; //striker, midfielder, defender, goalkeeper
}

// connection of Person and Role 
public class PersonRole {
    private Long person_id;
    private Long role_id;
}

// connection of Person and Position
public class PersonPosition {
    private Long person_id;
    private Long position_id;
}
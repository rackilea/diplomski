public class ModelEntity {
    @Id Long id;
}

@Entity
public class User extends ModelEntity {
    @Index
    String username;
}
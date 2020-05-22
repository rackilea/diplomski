@Entity
public class EntityA {    
    @Id private Integer id;
    @Lob
    byte[] tooHeavyToLoadAlways;
}

@Entity
@Table(name="EntityA")
public class EntityALightWeight {
    @Id private Integer id;
}
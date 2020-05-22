@Entity
@JsonIdentityInfo(
        generator = ObjectIdGenerators.PropertyGenerator.class,
        property = "idAgence",
        resolver = EntityIdResolver.class,
        scope=Agence.class)
public class Agence {
    // ... 
}
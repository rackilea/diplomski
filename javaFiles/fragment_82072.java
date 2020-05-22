@Entity
public class Player 
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @CollectionTable
    @ElementCollection
    @Convert(attributeName="value",converter=ListIntegerStringConverter.class)
    Map<String, List<Integer>> weaponAbilities;
}
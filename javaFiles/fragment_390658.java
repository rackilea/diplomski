@Entity
public class EquippableItem{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) 
    private long id;

    @Column
    private boolean isEquipped;

    @Column 
    private Item item;


    //getters and setters
}
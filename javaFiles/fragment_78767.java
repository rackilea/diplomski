@Entity
@Table(name = "parent")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Parent {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int parentId;
    private String name;

    @OneToMany(mappedBy="parent",fetch=FetchType.LAZY,cascade = CascadeType.PERSIST)
    private List<Child> child = new ArrayList<Child>();
}
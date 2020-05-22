@Entity
@Table(name = "child")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Child {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int childId;
    private String account;

    @ManyToOne(fetch = FetchType.LAZY, targetEntity = Parent.class)
    @JoinColumn(name="parentId", referencedColumnName = "parentId", nullable = false)
    private Parent parent;

}
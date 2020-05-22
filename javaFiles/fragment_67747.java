@Table(name = "section")
public class Section implements Serializable{   

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    @JsonProperty
    long id;    

    // Note: probably do not want to cascade REMOVE operations
    @ManyToMany(fetch = FetchType.LAZY,
        cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH, CascadeType.REFRESH},
        mappedBy = "sections")
    @JoinTable(
        name = "question_to_section"
        joinColumns =
            @JoinColumn(name="sectionId", referencedColumnName="ID"),
        inverseJoinColumns=
            @JoinColumn(name="questionId", referencedColumnName="ID")
    )
    Set<Question> questions = new HashSet<Question>(0);
    ...
}
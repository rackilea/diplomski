@Table(name = "translation")
@Entity
public class Translation implements Serializable {

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "element_id")
    private Element element;

}

@Entity
@Table(name = "element")
public class Element implements Serializable {

    @OneToMany
    (mappedBy="element")
    private List<Translation> translations;
}
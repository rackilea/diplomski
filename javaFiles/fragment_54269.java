@Table(name = "translation")
@Entity
public class Translation implements Serializable {

    @OneToOne
    @JoinColumn(name = "element_id")
    private Element element;

}

@Entity
@Table(name = "element")
public class Element implements Serializable {

    @OneToMany
    @JoinColumn(name = "element_id")
    private List<Translation> translations = new ArrayList<>();
}
@Table(name = "translation")
@Entity
public class Translation implements Serializable {

    @JsonIgnore    
    @OneToOne
    @JoinColumn(name = "element_id")
    private Element element;

}

@Entity
@Table(name = "element")
public class Element implements Serializable {

    @OneToOne
    (mappedBy="element")
    private Translation translation;
}
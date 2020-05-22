@Entity
@Table(name = "tbl_model")
public class Model extends AbstractBaseObject implements Auditable {

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "model", cascade = CascadeType.ALL)
    private Set<ModelParameterValue> parameterValues = new HashSet<>();
public class FieldRule implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected FieldRulePK fieldRulePK;
    @Basic(optional = false)
    @Column(name = "RuleValue")
    private String ruleValue;
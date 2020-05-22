@XStreamAlias("stage")
    public class Stage {

    private String name;

    @XStreamImplicit(itemFieldName="taskName")
    private List<String> tasks;

    @XStreamImplicit(itemFieldName="iconName")
    private List<String> icons;
    }
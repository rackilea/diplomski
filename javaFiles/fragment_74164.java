@ManagedBean
@RequestScoped
public class Bean {

    private List<String> items;

    @ManagedProperty("#{param.start}")
    private int start;

    @PostConstruct
    public void init() {
        // Just a stub. Do your thing to fill the items.
        items = new ArrayList<String>();
        int size = start + 10;

        for (int i = start; i < size; i++) {
            items.add("item " + (i + 1));
        }
    }

    public void setStart(int start) {
        this.start = start;
    }

    public List<String> getItems() {
        return items;
    }

}
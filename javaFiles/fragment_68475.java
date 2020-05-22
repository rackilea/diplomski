@ManagedBean
@ViewScoped
public class Bean {

    private List<Item> items;
    private DataModel<Item> model;
    private List<String> list;

    @PostConstruct
    public void init() {
        items = Arrays.asList(new Item(), new Item(), new Item());
        model = new ListDataModel<Item>(items);
        list = Arrays.asList("one", "two", "three");
    }

    public void change(AjaxBehaviorEvent e) {
        Item item = model.getRowData();
        item.setValue2(item.getValue1());
    }

    public DataModel<Item> getModel() {
        return model;
    }

    public List<String> getList() {
        return list;
    }

}
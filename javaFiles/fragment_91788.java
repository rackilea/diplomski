@ManagedBean(name="person")
@SessionScoped
public class PersonBean implements Serializable {

    private String selectedValue;
    private Map<String, SelectItem> availableValues;
    private List<SelectItem> lists; 

    public PersonBean() {
        availableValues = new LinkedHashMap<String, SelectItem>();
        availableValues.put("1", new SelectItem("1", "India", "desc1"));
        availableValues.put("2", new SelectItem("2", "canada", "desc2"));
        availableValues.put("3", new SelectItem("3", "america", "desc3"));
        lists = new ArrayList<SelectItem>(availableValues.values());
    }

    public void changeDD(ValueChangeEvent event) {
        String selectedValue = (String) event.getNewValue();
        SelectItem selectedItem = availableItems.get(newValue);
        // ...
    }

}
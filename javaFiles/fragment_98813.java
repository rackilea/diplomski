public class MyClass {
    private SelectItem notifyTypeItem = new SelectItem();

    public void foo() {
        notifyTypeItem.setTitle("Default Notification");
        notifyTypeItem.setWidth("100%");
        notifyTypeItem.setValueMap(new LinkedHashMap<String, String>() {{
                   put("0", "None");
                   put("1", "Subtle");
                   put("2", "Intrusive");
               }}
        );
    }
}
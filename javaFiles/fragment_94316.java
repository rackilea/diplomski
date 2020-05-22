public class MyApplication extends Application { 
    private List<Map<String, String>> items = new ArrayList<Map<String, String>>();

    public List<Map<String, String>> getItems() {
        return items;
    }

    public void setItems(List<Map<String, String>> items) {
      this.items = items;
    }
}
public class Label {
    public String id;
    public double amount;

    public Label(String id, double amount) {
        super();
        this.id = id;
        this.amount = amount;
    }

    public static Map<String, Label> makeUnique(List<Label> list) {
        Map<String, Label> map = new HashMap<String, Label>();

        for (Label label : list) {
            if(!map.containsKey(label.id)) map.put(label.id, label);
        }
        return map;
    }

    public static void main(String[] args) {
        List<Label> list = new ArrayList<Label>();
        list.add(new Label("1742", 10));
        list.add(new Label("1742", 11));
        list.add(new Label("1647", 12));
        list.add(new Label("1647", 14));
        Map<String, Label> map = makeUnique(list);
    }

}
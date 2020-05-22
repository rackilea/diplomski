public class Customers {

    private List<String> names;

    public Customers(List<String> names) {
        this.names = names;
    }

    public List<String> getNames() {
        return names;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (String name : this.names) {
            sb.append("Customer:");
            sb.append(name);
            sb.append("\n");
        }
        return sb.toString();
    }
}
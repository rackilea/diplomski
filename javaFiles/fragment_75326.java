class Employee
{
    private int id;
    private String data;

    public Employee() {
    }

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    public String getData() {
        return data;
    }

    public void setData(JsonNode node) {
        this.data = node.toString();
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", data='" + data + '\'' +
                '}';
    }
}
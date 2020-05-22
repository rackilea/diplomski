public static void main(String[] args) throws IOException {
    ObjectMapper mapper = new ObjectMapper();
    B b = mapper.readValue("{\"data\": \"false\"}", B.class);
    A a = mapper.readValue("{\"data\": {\"id\":5}}", A.class);
    System.out.println(b);
    System.out.println(a);
}

public static class A{
    private Data data;

    public Data getData() {
        return data;
    }

    public void setData(Data data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "A{" +
                "data=" + data +
                '}';
    }
}

public static class B extends A{
    private boolean data;

    @JsonIgnore
    @Override
    public Data getData() {
        return super.getData();
    }

    @JsonIgnore
    @Override
    public void setData(Data data) {
        super.setData(data);
    }

    public boolean isData() {
        return data;
    }

    public void setData(boolean data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "B{" +
                "data=" + data +
                '}';
    }
}

public static class Data{
    private int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Data{" +
                "id=" + id +
                '}';
    }
}
class MyModel {
    private String id;
    private String name;

    public MyModel(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public int hashCode() {
        return this.id.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof MyModel) {
            return this.id.equals(((MyModel) obj).id);
        }
        return false;
    }
}

ValueListBox<MyModel> semester = new ValueListBox<MyModel>(new Renderer<MyModel>() {
    public String render(MyModel object) {
        String s = "";
        if (object != null) {
            s = object.getName();
        }
        return s;
    }

    public void render(MyModel object, Appendable appendable) throws IOException {
        String s = render(object);
        appendable.append(s);
    }
}) {
    @Override
    public void setAcceptableValues(Collection<MyModel> newValues) {
        super.setAcceptableValues(new HashSet<MyModel>(newValues));
    }
};

semester.setAcceptableValues(Arrays.asList(new MyModel("1", "a"), new MyModel("1", "a"),
        new MyModel("2", "b"), new MyModel("3", "c")));
semester.setValue(new MyModel("1", "a"));
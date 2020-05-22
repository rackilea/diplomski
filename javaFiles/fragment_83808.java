class MyInterfaceList {
    @JsonProperty("rootname")
    private List<MyInterface> list;

    public List<MyInterface> getList() {
        return list;
    }

    public void setList(List<MyInterface> list) {
        this.list = list;
    }
}

final List<MyInterface> lists = new ArrayList<MyInterface>(4);
lists.add(new MyImpl(1L, "test name"));
MyInterfaceList listHolder = new MyInterfaceList();
listHolder.setList(lists);
final String json = mapper.writeValueAsString(listHolder);
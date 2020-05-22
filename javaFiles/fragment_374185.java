public static void main(String[] args) {
    MessageContainer m = new MessageContainer();
    m.setDescription("When settir\n");
    ArrayList<MessageContainer> list = new ArrayList<MessageContainer>();
    list.add(m);
    System.out.println(new Gson().toJson(list));
    String json = new Gson().toJson(list);
    ArrayList<MessageContainer>  resultList = new Gson().fromJson(json, new TypeToken<ArrayList<MessageContainer>>() {}.getType());
}
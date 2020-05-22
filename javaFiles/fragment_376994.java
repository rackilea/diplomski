Table table = new Table("table");
    List<String> listOfString = (List<String>) table.getList();

    List<MyPojo> listOfMyPojo = new ArrayList<MyPojo>();
    MyPojo myPojo1 = new MyPojo(listOfString.get(1), listOfString.get(3));
    listOfMyPojo.add(myPojo1);
    MyPojo myPojo2 = new MyPojo(listOfString.get(5), listOfString.get(7));
    listOfMyPojo.add(myPojo2);

    add(new ListView<MyPojo>("listview", listOfMyPojo) {
        protected void populateItem(ListItem<MyPojo> item) {
            MyPojo myPojo = item.getModelObject();
            item.add(new Label("name", myPojo.getName()));
            item.add(new Label("type", myPojo.getType()));
        }
    });
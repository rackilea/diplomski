// Preparing data ...
MyParcelableList list1 = new MyParcelableList();
list1.add(new MyParcelable(1));
MyParcelableList list2 = new MyParcelableList();
list2.add(new MyParcelable(2));
list2.add(new MyParcelable(3));
ArrayList<MyParcelableList> listOfList = new ArrayList<>();
listOfList.add(list1);
listOfList.add(list2);

// Send intent to your target activity
Bundle bundle = new Bundle();
bundle.putParcelableArrayList("KEY_OF_EXTRA", listOfList);
context.startActivity(new Intent(context, TargetActivity.class).putExtras(bundle));
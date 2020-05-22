BulkEditObservableList<Integer> intList = new BulkEditObservableList<>();
intList.addListener((Observable o) -> System.out.println(o));
intList.add(1);

intList.beginBulkChange();
intList.add(2);
intList.add(3);
intList.add(0, 0);
System.out.println("after multi add");
intList.endBulkChange();
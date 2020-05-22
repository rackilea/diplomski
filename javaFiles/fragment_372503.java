while (it.hasNext()){
     MenuItem item = new MenuItem(it.next());
     item.setOnAction(a->{ //lambda expression
        //..code logic here for each extension
     });
     format.getItems().add(item);
 }
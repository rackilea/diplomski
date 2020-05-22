box.getChildren().addListener(new ListChangeListener<Node>() {
     @Override
     public void onChanged(Change<? extends Node> c) {
         c.next();
         if(c.wasRemoved()){
              listOfImages.remove(c.getList().get(0));
         }
     }
});
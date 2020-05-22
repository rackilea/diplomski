List<CheckBox> checkboxes = new ArrayList<CheckBox>();
for(Topic t : Topic.values()) {
   Checkbox c = new Checkbox(t.toString());
   c.setOnAction(new EventHandler<ActionEvent>() {
      @Override
      public void handle(ActionEvent event) {
          if((CheckBox)event.getSource()).isSelected()) {
              filteredTopics.add(t);
          }
          else {
             filteredTopics.remove(t);
          }
      }
   });
   checkboxes.add(c);
}
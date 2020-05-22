public void setAllRoles()
{
thrshld = 0;
ObservableList<GroupEntry> groups = this.list2.getItems();
for (GroupEntry item : groups) {
  thrshld--;
}
thrshldMax = thrshld;

if (this.allRoles) {
  this.allRoles = false;
  for (GroupEntry item : groups) {
    item.setSelected(new SimpleBooleanProperty(false));
    item.isSelected().addListener(new ChangeListener<Boolean>() {
        @Override
        public void changed(ObservableValue<? extends Boolean> ov,
          Boolean old_val, Boolean new_val) {
            BooleanProperty thatCB = item.isSelected();
            if (thatCB.getValue() == true) {
              checkbox2.setIndeterminate(true);
              thrshld++; // = thrshld + 1;
            } else {
              thrshld--; // = thrshld - 1;
            } 
            if (thrshld == thrshldMax) {
              checkbox2.setIndeterminate(false);
              checkbox2.setSelected(false);
            }
            if (thrshld == 0) {
              checkbox2.setIndeterminate(false);
              checkbox2.setSelected(true);
            }
            //status.setText("state: " +thatCB.getValue()+ "\r\nthrshld: " +thrshld+ "Max: " +thrshldMax);
          }
    });
  }
  this.list2.refresh();
} else {
  this.allRoles = true;
  thrshld = 0;
  for (GroupEntry item : groups) {
    item.setSelected(new SimpleBooleanProperty(true));
    item.isSelected().addListener(new ChangeListener<Boolean>() {
        @Override
        public void changed(ObservableValue<? extends Boolean> ov,
          Boolean old_val, Boolean new_val) {
            BooleanProperty thisCB = item.isSelected();
            if (thisCB.getValue() == true) {
              thrshld++; // = thrshld + 1;
              if (thrshld == 0) {
                checkbox2.setIndeterminate(false);
                checkbox2.setSelected(true);
              }
            } else {
              checkbox2.setIndeterminate(true);
              thrshld--; // = thrshld - 1;
              if (thrshld == thrshldMax) {
                checkbox2.setIndeterminate(false);
                checkbox2.setSelected(false);
              }
            }
            //status.setText("state: " +thisCB.getValue()+ "\r\nthrshld: " +thrshld+ "Max: " +thrshldMax);
          }
    });
  }
  this.list2.refresh();
 }
}
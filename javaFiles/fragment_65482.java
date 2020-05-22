private class CustomAutoCompleteField extends AutoCompleteField {
      private int yOffset = 0;
      private int xOffset = 0;

      public CustomAutoCompleteField(BasicFilteredList filteredList) {
         super(filteredList);
      }

      protected void paint(Graphics g) {
         super.paint(g);
         if (xOffset == 0) {
            // initialize text offsets once
            xOffset = getEditField().getContentLeft();
            yOffset = getEditField().getContentTop();
         }
         String text = getEditField().getText();
         if (text == null || text.length() == 0) {
            int oldColor = g.getColor();
            g.setColor(Color.GRAY);
            g.drawText("enter text", xOffset, yOffset);
            g.setColor(oldColor);
         }
      }

      public void onSelect(Object selection, int SELECT_TRACKWHEEL_CLICK) {
         ListField _list = getListField();
         if (_list.getSelectedIndex() > -1) {
            if(selectedText!=null){
               BasicFilteredListResult result = (BasicFilteredListResult) selection;
               selectedText.setText(result._object.toString());
            }
         }
      }
   }
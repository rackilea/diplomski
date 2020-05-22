customFlowPanel.addDoubleClickHandler(new DoubleClickHandler() {           
      @Override         
      public void onDoubleClick(DoubleClickEvent event) {             
          Element clicked = event.getNativeEvent();
          if (!clicked.Equals(label.getElement())
          {
              doubleClicked();         
          }
      }     
});
canvas1.addEventHandler(MouseEvent.DRAG_DETECTED, 
           new EventHandler<MouseEvent>(){

       @Override
       public void handle(MouseEvent event) {
           canvas1.startFullDrag();       
       }
   });

c.addEventHandler(MouseDragEvent.MOUSE_DRAG_OVER, new EventHandler<MouseDragEvent>(){

       @Override
       public void handle(MouseDragEvent event) {
           c.setFill(colorPicker.getValue());   
       }
   });
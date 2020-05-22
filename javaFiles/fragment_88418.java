Image image= new Image();
image.addMouseOverHandler(new MouseOverHandler() {

        @Override
        public void onMouseOver(MouseOverEvent event) {
            PopupPanel p = new PopupPanel(true);
            Widget source = (Widget) event.getSource();
            int x = source.getAbsoluteLeft() + 10;
            int y = source.getAbsoluteTop() + 10;

            p.add(image); 
            p.setPopupPosition(x, y);
            p.show();
        }
    });
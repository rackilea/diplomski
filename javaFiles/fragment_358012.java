replacedAssets.addMouseListener (new MouseAdapter(){
            @Override
            public void mousePressed(MouseEvent mouseEvent) {
                super.mousePressed(mouseEvent);
                JTable table = (JTable) mouseEvent.getSource();
                if (mouseEvent.getClickCount() == 2 ) {
                    System.out.println("Double click detected");
                }
           }
   });
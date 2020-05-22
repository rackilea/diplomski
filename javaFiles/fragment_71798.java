cb.setOnKeyPressed(new EventHandler<KeyEvent>() {
                @Override
                public void handle(KeyEvent event) {
                   if("R".equals(ke.getText().toUpperCase() )) {
                       if(cb.isSelected()) {
                          cb.setSelected(false);
                        } else {
                          cb.setSelected(true);
                        }
                   }
                });
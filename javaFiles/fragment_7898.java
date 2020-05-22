tableView.addEventFilter(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {

            @Override
            public void handle(MouseEvent event) {
                if (event.getClickCount() == 2) {
                    System.out.println("on Click");

                    if (event.getTarget() instanceof ComboBox) {
                        System.out.println(((ComboBox) event.getTarget()).getSelectionModel().getSelectedItem());
                    }
                    if (event.getTarget() instanceof ComboBoxTableCell<?,?>) {
                        System.out.println(((ComboBoxTableCell) event.getTarget()).getItem().toString());
                    }
                }
            }



        });
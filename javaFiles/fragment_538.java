@Override
        public void drop(DragAndDropEvent event) {
          Notification.show("Dropped!");
          WrapperTransferable t = (WrapperTransferable) event.getTransferable();
          layout2.addComponent(t.getSourceComponent());
        }
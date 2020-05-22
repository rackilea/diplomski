int operations = DND.DROP_MOVE | DND.DROP_COPY | DND.DROP_LINK;
    Transfer[] types = new Transfer[] { SomeClassTransfer.getInstance() };
    DropTarget target = new DropTarget(tableViewer.getControl(), operations);
    target.setTransfer(types);

    target.addDropListener(new DropTargetListener() {
        @Override
        public void dragEnter(DropTargetEvent event) {
        }

        @Override
        public void dragOver(DropTargetEvent event) {
        }

        @Override
        public void dragLeave(DropTargetEvent event) {
        }

        @Override
        public void dragOperationChanged(DropTargetEvent event) {
        }

        @Override
        public void dropAccept(DropTargetEvent event) {
        }

        @Override
        public void drop(DropTargetEvent event) {
            if (event.data == null) {
                // no data to copy, indicate failure in event.detail
                event.detail = DND.DROP_NONE;
                return;
            }
            // data copied to viewer
            tableViewer.add((ISomeClass) event.data);
        }
    });
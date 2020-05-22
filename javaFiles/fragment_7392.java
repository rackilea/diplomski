int operations = DND.DROP_MOVE | DND.DROP_COPY | DND.DROP_LINK;
    Transfer[] types = new Transfer[] { SomeClassTransfer.getInstance() };
    DragSource source = new DragSource(tableViewer.getControl(), operations);
    source.setTransfer(types);

    source.addDragListener(new DragSourceListener() {
        @Override
        public void dragStart(DragSourceEvent event) {
            if (tableViewer.getSelection().isEmpty()) {
                // do not start drag
                event.doit = false;
            }
        }

        @Override
        public void dragSetData(DragSourceEvent event) {
            if (SomeClassTransfer.getInstance().isSupportedType(
                    event.dataType)) {
                event.data = ((IStructuredSelection) tableViewer
                        .getSelection()).getFirstElement();
            }
        }

        @Override
        public void dragFinished(DragSourceEvent event) {
            // A Move operation has been performed so remove the data
            // from the source
            if (event.detail == DND.DROP_MOVE) {
                tableViewer.remove(((IStructuredSelection) tableViewer
                        .getSelection()).getFirstElement());
            }
        }
    });
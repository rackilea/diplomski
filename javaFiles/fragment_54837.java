JComponent dropTargetComponent = ...;
new DropTarget(dropTargetComponent , DnDConstants.ACTION_COPY,
    new DropTargetListener() {

        public void drop(DropTargetDropEvent dtde) {
            Transferable tr = dtde.getTransferable();
            if(tr.isDataFlavorSupported(java.awt.datatransfer.DataFlavor.imageFlavor)) {
                 Image image = (Image) tr.getTransferData(java.awt.datatransfer.DataFlavor.imageFlavor);
                 // Do something with image
            }
         }

         ...
   }
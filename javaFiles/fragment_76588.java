scrDocuments.setDropTarget(new DropTarget() {
        @Override
        public synchronized void drop(DropTargetDropEvent evt) {
            try {
                Transferable transfer = evt.getTransferable();
                if(transfer.isDataFlavorSupported(DataFlavor.javaFileListFlavor)) {
                    evt.acceptDrop(DnDConstants.ACTION_COPY_OR_MOVE);
                    List objects = (List)transfer.getTransferData(DataFlavor.javaFileListFlavor);
                    for(Object object : objects) {
                        if(object instanceof File) {
                            File file = (File)object;
                            // store file ...
                        }
                    }
                } else {
                    try {
                        String url = fetchURL(evt, transfer);
                        ImapMessage eml = new ImapMessage(url);
                        File file = eml.fetchMessage();
                        // store file ...
                    } catch(Exception ex) {
                        System.err.println(ex.getMessage());
                    }
                }
            } catch(Exception ex) {
                System.err.println(ex.getMessage());
            } finally {
                evt.dropComplete(true);
            }
        }
    });

private String fetchURL(DropTargetDropEvent evt, Transferable transfer) throws IOException, UnsupportedEncodingException, UnsupportedFlavorException {
    for(DataFlavor flavor : transfer.getTransferDataFlavors()) {
        if(flavor.isRepresentationClassInputStream()) {
            if(flavor.getHumanPresentableName().equals("application/x-moz-file-promise-url")) {
                evt.acceptDrop(DnDConstants.ACTION_COPY_OR_MOVE);
                BufferedReader reader = new BufferedReader(new InputStreamReader((InputStream)transfer.getTransferData(flavor), "ISO-8859-1"));
                String fAddress = reader.readLine();
                reader.close();
                return fAddress;
            }
        }
    }
    throw new IOException("No transferable object or stream found.");
}
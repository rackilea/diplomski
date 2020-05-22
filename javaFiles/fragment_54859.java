private class FileTransferHandler extends TransferHandler {

    @Override
    protected Transferable createTransferable(JComponent c) {
        JList list = (JList) c;
        List<File> files = new ArrayList<File>();
        for (Object obj: list.getSelectedValues()) {
            files.add((File)obj);
        }
        return new FileTransferable(files);
    }

    @Override
    public int getSourceActions(JComponent c) {
        return MOVE;
    }
}

private class FileTransferable implements Transferable {

    private List<File> files;

    public FileTransferable(List<File> files) {
        this.files = files;
    }

    public DataFlavor[] getTransferDataFlavors() {
        return new DataFlavor[]{DataFlavor.javaFileListFlavor};
    }

    public boolean isDataFlavorSupported(DataFlavor flavor) {
        return flavor.equals(DataFlavor.javaFileListFlavor);
    }

    public Object getTransferData(DataFlavor flavor)
            throws UnsupportedFlavorException, IOException {
        if (!isDataFlavorSupported(flavor)) {
            throw new UnsupportedFlavorException(flavor);
        }
        return files;
    }
}
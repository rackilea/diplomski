public class DataWrapperTransferable implements Transferable {
    public static DataFlavor FLAVOR = new DataFlavor(DataWrapper.class,
            "DataWrapper");

    private DataFlavor flavors[];
    private DataWrapper dataWrapper;

    public DataWrapperTransferable(String data, Object source) {
        dataWrapper = new DataWrapper(data, source);
        flavors = new DataFlavor[] { FLAVOR };
    }

    @Override
    public Object getTransferData(DataFlavor flavor)
            throws UnsupportedFlavorException, IOException {
        if (flavor.equals(FLAVOR)) {
            return dataWrapper;
        } else {
            throw new UnsupportedFlavorException(flavor);
        }
    }

    @Override
    public DataFlavor[] getTransferDataFlavors() {
        return flavors;
    }

    @Override
    public boolean isDataFlavorSupported(DataFlavor flavor) {
        return flavor.equals(FLAVOR) || flavor.equals(DataFlavor.stringFlavor);
    }
}
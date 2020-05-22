public class LayerContainer extends JPanel {

    public LayerContainer() {
        this.setTransferHandler(new ValueImportTransferHandler());
        this.setLayout(new GridBagLayout()); // Optional layout
        this.setBorder(new CompoundBorder(new LineBorder(Color.DARK_GRAY), new EmptyBorder(20, 20, 20, 20))); // Optional border
    }

    protected static class ValueImportTransferHandler extends TransferHandler {

        public static final DataFlavor SUPPORTED_DATE_FLAVOR = DataFlavor.stringFlavor;

        public ValueImportTransferHandler() {
        }

        @Override
        public boolean canImport(TransferHandler.TransferSupport support) {
            return support.isDataFlavorSupported(SUPPORTED_DATE_FLAVOR);
        }

        @Override
        public boolean importData(TransferHandler.TransferSupport support) {
            boolean accept = false;
            if (canImport(support)) {
                try {
                    Transferable t = support.getTransferable();
                    Object value = t.getTransferData(SUPPORTED_DATE_FLAVOR);
                    if (value instanceof String) { // Ensure no errors
                        // TODO: here you can create your own handler
                        // ie: ((LayerContainer) component).getHandler()....
                        Component component = support.getComponent();
                        LayerItem j = new LayerItem((String) value);
                        ((LayerContainer) component).add(j); // Add a new drag JLabel
                        accept = true;
                    }
                } catch (Exception exp) {
                    exp.printStackTrace();
                }
            }
            return accept;
        }
    }

}
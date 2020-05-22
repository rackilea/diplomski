String result = "";
Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
Transferable contents = clipboard.getContents(null);
boolean hasStringText = (contents != null) && contents.isDataFlavorSupported(DataFlavor.stringFlavor);
if (hasStringText) {
    try {
        result = (String)contents.getTransferData(DataFlavor.stringFlavor);
    } catch (UnsupportedFlavorException | IOException ex) {
        System.out.println(ex); ex.printStackTrace();
}
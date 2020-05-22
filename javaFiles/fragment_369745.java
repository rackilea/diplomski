// Step 1 ) get old text
String oldText = "";
try {
    oldText = (String) Toolkit.getDefaultToolkit().getSystemClipboard().getData(DataFlavor.stringFlavor); 
} catch (UnsupportedFlavorException ufe) {
    ufe.printStackTrace();
} catch (IOException ioe) {
    ioe.printStackTrace();
}

// Step 5 ) Reset clipboard
setClipboard(oldText);
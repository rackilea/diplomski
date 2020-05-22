public static int kindOfContents() {
    Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
    Transferable contents = clipboard.getContents(null);

    if(contents.isDataFlavorSupported(DataFlavor.stringFlavor)) {
        // String, save temporarily as string and write back as string
        return 0;
    } else if(contents.isDataFlavorSupported(DataFlavor.imageFlavor)) {
        // Image, save temporarily as BufferedImage and write back as image
        return 1;
    } else if(contents.isDataFlavorSupported(DataFlavor.javaFileListFlavor)) {
        // List of files, save temporarily as java.util.List interface and write back as the file lists
        return 2;
    }

}
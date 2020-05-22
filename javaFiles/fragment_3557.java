Clipboard cb = Toolkit.getDefaultToolkit().getSystemClipboard();
if (cb.isDataFlavorAvailable(DataFlavor.javaFileListFlavor)) {
    try {
        List files = (List) cb.getData(DataFlavor.javaFileListFlavor);
        boolean found = false;
        for (Object o : files) {
            if (o instanceof File) {
                File f = (File) o;
                if (f.getName().toLowerCase().endsWith(".mp3")) {
                    System.out.println("I haz MP3");
                    found = true;
                }
            }
        }
        if (!found) {
            System.out.println("I notz haz MP3");
        }
    } catch (UnsupportedFlavorException ex) {
        ex.printStackTrace();
    } catch (IOException ex) {
        ex.printStackTrace();
    }
}
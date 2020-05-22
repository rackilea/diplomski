if (Desktop.isDesktopSupported()) {
        try {
            File myFile = new File("path");
            Desktop.getDesktop().open(myFile);
        } catch (IOException ex) {

        }
    }
try {
        URL imageUrl = new URL("http://domain/anotherimage.png"); // your URL or link
        InputStream in = imageUrl.openStream();
        Path outputPath = Paths.get("downloaded.png"); // your directoryToBeSavedInAndName
        Files.copy(in, outputPath, StandardCopyOption.REPLACE_EXISTING);
        PictureView view = new PictureView(new ImageIcon("downloaded.png"));  // your directoryToBeSavedInAndName
        view.pack();
        view.setVisible(true);
    } catch (Exception e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
    }
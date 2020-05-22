try {
        URL imageUrl = new URL("http://domain/oneimage.png"); // your URL or link
        PictureView view = new PictureView(new ImageIcon(imageUrl));
        view.pack();
        view.setVisible(true);
    } catch (Exception e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
    }
Thread awesomeThread = new Thread(new Runnable(){

    @Override
    public void run() {
        while(true){

            try{
                //Read the image
                final Image img = ImageIO.read(socket.getInputStream());
                System.out.println("Image Read");  //code for troubleshooting

                //Once an image is read, notify the GUI to update
                SwingUtilities.invokeLater(new Runnable(){
                    @Override
                    public void run() {
                        ImageIcon icon = new ImageIcon(img);
                        label.setIcon(icon);
                        System.out.println("Image updated"); //code for troubleshooting
                    }});
            } catch (IOException e) {}
        }
    }});

   awesomeThread.start();
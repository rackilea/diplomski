startC.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                OpenCVWebCam webCam = (OpenCVWebCam) cam;
                try {
                    webCam.start();
                } catch (Exception e3) {                    
                    e3.printStackTrace();
                }

                OpenCVFrameGrabber grabber = new OpenCVFrameGrabber(0);
                try {
                    grabber.start();
                } catch (Exception e3) {            
                    e3.printStackTrace();
                }

                try {
                    IplImage frame = grabber.grab();
                    BufferedImage out = frame.getBufferedImage();   
                    File outputfile = new File("c:\\saved.png");
                    ImageIO.write(out, "png", outputfile);
                } catch (Exception e2) {                    
                    e2.printStackTrace();
                }
}
});
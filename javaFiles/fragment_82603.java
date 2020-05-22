new Thread(){
    public void run(){
        Robot robot = new Robot();
        BufferedImage bi=robot.createScreenCapture(new Rectangle(0,25,1366,744));
        JFrame frame = new JFrame();
        frame.toFront();
        frame.requestFocus();
        frame.setAlwaysOnTop(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        String name = JOptionPane.showInputDialog(frame, "Enter file name");
        frame.dispose();
        String fileName= dovalidateFile(name);
        FileNameExtensionFilter filter = new FileNameExtensionFilter("PNG", ".png");
        fileChooser.setFileFilter(filter);
        fileChooser.setSelectedFile(new File (fileName));
        int returnVal = fileChooser.showSaveDialog(null);
        if ( returnVal == JFileChooser.APPROVE_OPTION )
        {
            File file = fileChooser.getSelectedFile();
            final File validatedFile = validateFile(file);
            System.out.println(file);
            try{
                ImageIO.write(bi, "png", validatedFile);
            }catch(Excepion e){
                e.printStackTrace();
            }

        }
    }
}.start();
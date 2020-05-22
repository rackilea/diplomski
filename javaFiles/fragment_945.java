stopChecking.addMouseListener(new MouseAdapter() {
    @Override
    public void mousePressed(MouseEvent e) {

        //To clarify the following uses a INSTANCE of CheckFiles, called CheckFiles.
        //In other words, somewhere there was a declaration with the format:
        // CheckFiles CheckFiles = ...

        CheckFiles.stop = true;
        CheckFiles.interrupt(); //Or whatever the name of your thread instance is
        System.out.println(CheckFiles.stop); //Prints true when pressed

    }
});
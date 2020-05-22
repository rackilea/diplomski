public void showFileDialog( JavascriptFunction someJavascriptFunction ) {
    SwingUtilities.invokeLater( new Runnable() {
        public void run() {
            JFileChooserDialog chooser = new JFileChooser();
            ...
            int option = chooser.showOpenDialog( parent );

            someJavascriptFunction.invoke( option == JFileChooser.APPROVE_OPTION ? 
                                           chooser.getSelectedFile().getAbsolutePath() : 
                                           null );
        }
    });
}
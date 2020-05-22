class MyWindowListener extends WindowAdapter {

    public void windowClosing(WindowEvent e){
         Frame frame = (Frame) e.getSource();
         frame.dispose();
    }

}
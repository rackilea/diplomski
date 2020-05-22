private void shoe() {
    Component parent = this;
    Window[] allWindows = Window.getWindows();
    for(Window window : allWindows){
        //Validate and find the appropriate window by its instance name or someother mean
        parent  = window;
     }

    JOptionPane.showMessageDialog(parent, "HEELO");
}
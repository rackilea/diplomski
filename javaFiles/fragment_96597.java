if(Allow.allow_ == true) {
    Allow.allow_ = false;
    secondFrame sFrame_ = new secondFrame();
    sFrame_.setVisible(true);
} else {
    //alert the user that the frame is already open
    //I recommend a JOptionPane such as this
    JOptionPane.showMessageDialog(null, "This window is already open");
}
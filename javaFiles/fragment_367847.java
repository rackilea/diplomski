walkerButton.addActionListener(new java.awt.event.ActionListener() {
    public void actionPerformed(java.awt.event.ActionEvent evt) {
        walkerButtonActionPerformed(evt);
    }
});

private void walkerButtonActionPerformed(java.awt.event.ActionEvent evt) {                                             

    // if walker button is disabled exit the method
    if (!walkerButton.isEnabled()) {
        return;
    }       

    // Disable the button before starting the loop
    walkerButton.setEnabled(false);

    int steps = 20;
    int stepDistance = 2;        

    while (steps > 0) {  
        // Set the walker button new location          
        int x = walkerButton.getX() + stepDistance;
        int y = walkerButton.getY() + stepDistance;
        walkerButton.setLocation(x, y);
        steps--;
    }  

    // Enable the button after the loop execution
    walkerButton.setEnabled(true);
}
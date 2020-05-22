@Override
protected void paintComponent(Graphics g){
    // Get copy
    Graphics gCopy = g.create();
    // Draw on copy
    ...
    // Dispose of copy
    gCopy.dispose();
}
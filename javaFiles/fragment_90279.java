MouseListener ml = new MouseAdapter() {
     public void mousePressed(MouseEvent e) {
         if(SwingUtilities.isRightMouseButton(e)){
         int selRow = tree.getRowForLocation(e.getX(), e.getY());
         TreePath selPath = tree.getPathForLocation(e.getX(), e.getY());
                 tree.setSelectionPath(selPath); 
                 if (selRow>-1){
                    tree.setSelectionRow(selRow); 
                 }
     }
 };
 tree.addMouseListener(ml);
jTable.addMouseListener(new java.awt.event.MouseAdapter() {
     public void mouseClicked(java.awt.event.MouseEvent evt) {
         Point p = new Point(evt.getX(), evt.getY());
         int col = jTable.columnAtPoint(p);
         int row = jTable.rowAtPoint(p);
         if (evt.getButton() == MouseEvent.BUTTON1)
         {
            if (evt.getClickCount() >= 2)
            {
               ...
               ...
            }
        });
table.addMouseListener(new MouseAdapter(){
            public void mouseReleased(MouseEvent e)
            {
                rowClicked = rowAtPoint(e.getPoint());
                colClicked = columnAtPoint(e.getPoint());
            }

            public void mouseClicked(MouseEvent e)
            {
                rowClicked = rowAtPoint(e.getPoint());
                colClicked = columnAtPoint(e.getPoint());
            }
        });
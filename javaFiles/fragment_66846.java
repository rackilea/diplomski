JPanel[] cellr = new JPanel[rows*columns];
    for(int i=0;i<rows*columns; i++){
        cellr[i] = new JPanel();
        cellr[i].setLayout(new GridBagLayout());
        mazeFrame.getContentPane().add(cellr[i]);
    }

   GridBagConstraints g = new GridBagConstraints();
   for(int i=0;i<rows*columns; i++){
        CellPanel cell = new CellPanel(wall.getImage());
        cell.setPreferredSize(new Dimension(mazeFrame.getWidth()/columns,mazeFrame.getHeight()/rows));
        g.fill = GridBagConstraints.BOTH;
        g.weightx = 1;
        g.weighty = 1;
        cellr[i].add(cell,g);
    }
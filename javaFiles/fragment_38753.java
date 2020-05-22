GridBagConstraints c = new GridBagConstraints();
    c.weightx = 1;
    for(int i=0; i<nOfCells; i++){
        for(int k=0; k<nOfCells; k++){

            c.gridx = i;
            c.gridy= k;
            this.add(Box.createRigidArea(new Dimension(DEFAULT_WIDTH, DEFAULT_HEIGHT)), c);
        }
    }
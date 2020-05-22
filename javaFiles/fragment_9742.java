for(int i=p;i>0;i-=size){
        for(int j=0;j<o;j+=size){
            jButton[k][l] = new javax.swing.JButton();
            jButton[k][l].setBounds(j, i, size, size);
            jButton[k][l].setBackground(Color.yellow);
            javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
            this.setLayout(layout);
for(int i=0;i < products.size(); i++){
        btnDeleteproduct = new JButton("X");
        btnDeleteproduct.setBounds(380, verticalPosition + i * productOffset, 20, 20);
        btnDeleteproduct.setFont(WinkelApplication.FONT_10_BOLD);
        btnDeleteproduct.setName("" + i);
        btnDeleteproduct.addActionListener(this);
        this.add(btnDeleteproduct);
    }
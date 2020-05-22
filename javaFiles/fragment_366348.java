public void buildGUI() {

        //defines the Layout for the main Frame
        this.setLayout(new GridLayout(3,1)) //its up to you wich Layout you use

        //Add components and build GUI Frame
        this.add(panel3);
        this.add(panel2);
        this.add(panel1);

        //Set attributes
        //Pack components together inside of frame
        pack();
        //Center of screen
        setLocationRelativeTo(null);
        //Make frame visible
        setVisible(true);
    }
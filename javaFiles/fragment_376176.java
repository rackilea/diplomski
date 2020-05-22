private String id;
    private int cc;
    private JButton[] button = new JButton[9];
    private String[] ids = new String[button.length];

    //cc += 1;
    //id += ""+cc;
    id += Integer.toString(++cc); //easier way

    for(int a=0; a<9; a++){
        // dd refers to the variable for the image pieces for each JButton
        button[a].setIcon(new ImageIcon( dd ));
        ids[a] = id;
    }
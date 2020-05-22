ResultSet rs = stmt.executeQuery();

    // stores the results into a collection
    List<JRadioButton[]> radioButtonList = new ArrayList<>();
    List<JLabel> labelList = new ArrayList<>();

    // iterate thru result set        
    while(rs.next()){
        // prints to console
        System.out.println(rs.getInt(1) + " " + rs.getInt(8));

        // init label
        JLabel l = new JLabel();
        l.setBounds(30,40,450,20);

        // set text for label
        l.setText(rs.getInt(2) + " " + rs.getString(3));

        // at least one element, set to visible
        l.setVisible(true);

        // store values from rs into an array of radio buttons
        JRadioButton[] jb = new JRadioButton[5];
        jb[0].setText(rs.getString(4));
        jb[1].setText(rs.getString(5));
        jb[2].setText(rs.getString(6));
        jb[3].setText(rs.getString(7));

        // store object in list for future use
        radioButtonList.add( jb );

        //store label in list
        labelList.add(l);
    }


    // now loop thru the lists
    for(JRadioButton[] jbArray : radioButtonList){
        // your code here - update to suit your needs
        // jbArray[4].setBounds(50,80,200,20); // not sure what the values should be here
    }

    for(JLabel jLabel: labelList){
        // your code here - update to suit your needs
        // jLabel.setBounds(50,80,200,20); // not sure what the values should be here            
    }
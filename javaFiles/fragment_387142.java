public void fillTimetablePane(JPanel pane){
    int noOfRows = pref.getNoOFPeriods()+1; 
    pane.setLayout(new GridLayout(noOfRows,4));
    pane.setBorder(BorderFactory.createLineBorder(Color.black));
    //JLabel label = new JLabel();   // from here
    int i=0;                         //   V
    while (i<4){                     //   V
        JLabel label = new JLabel(); // to here
        switch (i) {
        case 0: label.setText("Lesson");
                break;
        case 1: label.setText("Period");
                break;
        case 2: label.setText("Room");
                break;
        case 3: label.setText("Teacher");
                break;
        }
        i++;
        pane.add(label);
    }
}
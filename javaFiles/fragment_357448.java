JFrame processDetail = new JFrame("Enter information for processes");
JPanel panelDetail = new JPanel(new FlowLayout());
processDetail.setSize(500, 500);
//processDetail.setVisible(true); Not here,
String[] processes = {"1" , "2", "3", "4"};

JComboBox[] AT = new JComboBox[4];  //initailse drop down, numProcc is user integer...
for (int i = 0; i < 4; i++) {
    AT[i] = new JComboBox(processes); //processes is array of numbers
    System.out.println(i); //a check to see it was looping
    panelDetail.add(AT[i]);
}
//add the panel to the frame
processDetail.add(panelDetail);
processDetail.setVisible(true); // <--- but here.
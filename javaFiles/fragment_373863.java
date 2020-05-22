public void init(){
    Container guiContainer = getContentPane();
    LayoutManager layout = new FlowLayout();
    guiContainer.setLayout(layout);


    //Create Championship Button
    final JButton createChampButton = new JButton("Create Championship");
    guiContainer.add(createChampButton);



    //Create Club Button
    final JButton createClubButton = new JButton ("Create Club");
    guiContainer.add(createClubButton);


    //Create Athlete Button
    final JButton createAthleteButton = new JButton ("Create Athlete");
    guiContainer.add(createAthleteButton);


    //Print Athletes Button
    final JButton printAthletesButton = new JButton ("Print all Athletes");
    guiContainer.add(printAthletesButton);


    //The quiet Listener
    ActionListener aListener = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent event){
            JButton button = (JButton) event.getSource();
            //if (button.equals(printAthletesButton)){
                //JOptionPane.showMessageDialog(null, "Athlete name is: " +anAthlete.GetAthleteName());
            //  JOptionPane.showMessageDialog(null, "Athlete age is: " + anAthlete.GetAge());
                //}
            if(button.equals(createChampButton)){
                    Championship aChampionship = new Championship("","");
                    aChampionship.champName = JOptionPane.showInputDialog("Enter Championship Name: ");
                    aChampionship.duration = JOptionPane.showInputDialog("Enter Championship Duration: ");
            }       
        }
    };
    printAthletesButton.addActionListener(aListener);
    createAthleteButton.addActionListener(aListener);
    createClubButton.addActionListener(aListener);
    createChampButton.addActionListener(aListener);

}
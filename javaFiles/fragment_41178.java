public void dismount(){
    if (myArmy.warrior == null){
      myArmy.warrior = new Warrior(myArmy);
      myArmy.getOurArmyWindow().getTabbedPane().addTab("(Ethan)", new ImageIcon("images/warriorIcon.jpg"), warrior.genGetPanel()); //This is just adding the Warrior's tab to my GUI. It's not relevant to the problem.
    }
    ...//Some stuff to handle when the method is called and warriorCreated is true
    }//end dismount()
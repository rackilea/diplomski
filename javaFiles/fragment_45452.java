public void doAction() {
 AboutMe.setLocation(470,250);
          AboutMe.setSize(400, 200);
          AboutMe.setVisible(true);
          AboutMe.setResizable(false);
          AboutMe.add(panel5);
          panel5.setLayout(null);
          panel5.add(ta);

         ta.setBounds(15, 15, 350, 130);
         ta.setBorder(BorderFactory.createEtchedBorder());
         ta.setText("...................................\n"
                 +  "....................................\n"
                 +  "....................................\n"
                 +  "....................................\n"
                 +  "....................................");
         ta.setEditable(false);
}
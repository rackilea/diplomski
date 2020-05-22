final int NUMBER_OF_PLAYERS=4;
    int count=0;



     nextButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                count++; 
                if(count-1==NUMBER_OF_PLAYERS) 
                  {
                  nextButton.setEnabled(false);  //disable the button
                  }

              ///Your code

            }
        });
public void actionPerformed(ActionEvent event){


        if(turn == true){

            rollResult = roll();

            rolls++;
            start = false;
            updateUI();
            System.out.println( rollResult );

        }
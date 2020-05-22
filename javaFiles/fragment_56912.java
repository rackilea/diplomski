if (turncount % 2 == 0)
        {
            if (topl.getText().equals(""))
            {
                topl.setText("X");
                turncount  += 1;
                winchecker();

            }
        } // ADDED
        else
        { // ADDED
            if (topl.getText().equals(""))
            {
                topl.setText("O");
                turncount  += 1;
                winchecker();
            }
        }
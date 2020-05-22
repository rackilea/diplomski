@Override
    public void onClick(View v) {
        if (!((Button) v).getText().toString().equals("")) {
            return;
        }
                ((Button) v).setText("X");
                ((Button) v).setTextColor(playerX);
                playerOneMove = false;
                switchPlayerTurn();
                computerMove();
                playerOneMove = true;
                switchPlayerTurn();

        turnsCount++;
    }

    private boolean computerMove() {

        String[][] field = new String[3][3];

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                field[i][j] = buttons[i][j].getText().toString();
                if (field[i][j].equals("")) {
                    buttons[i][j].setText("O");
                    buttons[i][j].setTextColor(playerO);
                    turnsCount++;
                    return true;
                }
            }
        }
        return false;
    }



    private boolean checkGameIsWon() {
        String[][] field = new String[3][3];
        Boolean isDone = false.
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                field[i][j] = buttons[i][j].getText().toString();
            }
        }

        for (int i = 0; i < 3; i++) {
            if (field[i][0].equals(field[i][1])
                    && field[i][0].equals(field[i][2])
                    && !field[i][0].equals("")) {
                isDone = true;
            }
        }

        for (int i = 0; i < 3; i++) {
            if (field[0][i].equals(field[1][i])
                    && field[0][i].equals(field[2][i])
                    && !field[0][i].equals("")) {
                isDone = true;
            }
        }

        if (field[0][0].equals(field[1][1])
                && field[0][0].equals(field[2][2])
                && !field[0][0].equals("")) {
            isDone = true;
        }

        if (field[0][2].equals(field[1][1])
                && field[0][2].equals(field[2][0])
                && !field[0][2].equals("")) {
            isDone = true;
        }
           if(isDone){
              if (playerOneMove) {
                  player1Wins();
                  return true;
              } else {
                  player2Wins();
                  return true;
              }
          }
          if (turnsCount == 9) {
              draw();
              return true;
          }
      }
    return false;
    }

    private void player1Wins() {
        playerOnePoints++;
        Toast.makeText(this, "Player 1 wins!", Toast.LENGTH_SHORT).show();
        updatePointsText();
        resetBoard();
    }

    private void player2Wins() {
        playerTwoPoints++;
        Toast.makeText(this, "Computer wins!", Toast.LENGTH_SHORT).show();
        updatePointsText();
        resetBoard();
        computerMove();
        playerOneMove = true;
        switchPlayerTurn();
    }
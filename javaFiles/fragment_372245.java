int count = 0;
boolean isWinner = false;
for (int row = 0; row < area.length; row++) {
    for (int column = 0; column < area[row].length; column++) {
        if (area[row][column] == player && count < 5)
            count++;
        else if(count == 5){
            isWinner = true;
            break;
        }
        else{
            isWinner = false;
            count = 0;
        }
    }

    if(isWinner)
        break;

}


return isWinner;
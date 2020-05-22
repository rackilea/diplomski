public void processLightClick(int row, int col) { 
    states[row][col] = !states[row][col];

    if(states[row][col] == true){
        lights[row][col].setFill(ON_PAINT);
    }
    else if(states[row][col] == false){
        lights[row][col].setFill(OFF_PAINT);
    }
    turns++; 

    System.out.println(row+":"+col);
    status.setText("Turn Number " + turns);
}
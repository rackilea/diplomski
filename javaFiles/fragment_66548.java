StringBuilder builder = new StringBuilder();
for(int i = 0; i < boardOne.length; i++){
    for(int j = 0; j < boardOne[i].length; j++){
        builder.append(boardOne[i][j]);
        builder.append(" ");
    }
    builder.append("\n");
}

txtField.setText(builder.toString());
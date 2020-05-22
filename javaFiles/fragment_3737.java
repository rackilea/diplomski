for(int i = 0; i<4; i++){
        TableRow tr = new TableRow(this);
        for(int r = 1; r<4; r++){
            tr.addView(new Button()); // new Button() instead of but[i][j]
        }
        field.addView(tr);
    }
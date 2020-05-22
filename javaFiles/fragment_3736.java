for(int i = 0; i<4; i++){
        TableRow tr = new TableRow(this);
        for(int r = 1; r<4; r++){
            tr.addView(but[i][r]);
        }
        field.addView(tr);
    }
while (line != null){

        TableRow tblRow = new TableRow(this);
        tblRow.setPadding(5, 30, 5, 5);
        table.addView(tblRow);

        for (int col = 0; col < NUM_COL; col++) {
            if (line != null) {
                //Normal flow
                Button btn = new Button(this);
                btn.setTextSize(14);
                btn.setText(line);
                btn.setOnClickListener(this);
                tblRow.addView(btn);
                line = reader.readLine();
             }else{
                //Guaranteed to happen on odd number of lines since NUM_COL=2
                //Might want to add a dummy view here if the missing button affects the table display

                //NOP

             }

        }
}
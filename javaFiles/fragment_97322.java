JButton btnRefresh = new JButton("Refresh");
        btnRefresh.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent arg0) {
                table.setModel(new DefaultTableModel(dataArray(),
                        new String[] { "first", "second", "third", "fourth" }));//Changes the column headers
                panel.revalidate();
            }
            private Object[][] dataArray() {
                Object[][] table = new Object[5][4];//5 = rows 4 = columns
                for (int i = 0; i < 5; i++) {
                    for(int j = 0; j< 4; j++){                  
                            if(j == 0){
                                table[i][j] = i+1;
                            }else if(j== 1){
                                table[i][j] = "Second Row";//Change these strings to whatever variable you want to fill the second row with, same with the other 3.
                            }else if(j== 2){
                                table[i][j] = "Third Row";
                            }else{
                                table[i][j] = "Fourth Row";
                            }
                        }
                    }
                return table;
            }
        });
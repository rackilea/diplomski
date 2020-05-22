public void Data(String x){
    boolean b = false;
    for (int i = 1; i < 6; i++) {
        if (x.equalsIgnoreCase(table1[i][1])){
            for (int j = 0; j < 4; j++) {
                System.out.printf("|%-40s", table1[i][j]);
            }
        }
        else if (x.equalsIgnoreCase(table2[i][1])){
            for (int j = 0; j < 4; j++) {
                System.out.printf("|%-40s", table2[i][j]);
            }
        }
        else if (x.equalsIgnoreCase(table3[i][1])){
            for (int j = 0; j < 4; j++) {
                System.out.printf("|%-40s", table3[i][j]);
            }
        }
        else if (x.equalsIgnoreCase(table4[i][1])){
            for (int j = 0; j < 4; j++) {
                System.out.printf("|%-40s", table4[i][j]);
            }
        }
        else if (x.equalsIgnoreCase(table5[i][1])){
            for (int j = 0; j < 4; j++) {
                System.out.printf("|%-40s", table5[i][j]);
            }
        }
        else if (x.equalsIgnoreCase(table6[i][1])){
            for (int j = 0; j < 4; j++) {
                System.out.printf("|%-40s", table6[i][j]);
            }
        }
        else if (x.equalsIgnoreCase(table7[i][1])){
            for (int j = 0; j < 4; j++) {
                System.out.printf("|%-40s", table7[i][j]);
            }
        }
        else b = true;
    }
    if (b) System.out.println("Data not found!");
}
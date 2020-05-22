for (int i = 0; i < a.pattern_cnt; i++) {
            for (int j = 0; j < a.T_element_cnt; j++) {
             System.out.printf("%.3f\t", a.O[i][j]); //console output

             t1.append(String.format("%.3f\t", a.O[i][j]));//jtextarea output
            }

            System.out.println();
            t1.append("\n");

        }
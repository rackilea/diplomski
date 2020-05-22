Object[] tempTitel = titel.toArray(); // return Object[]

      String[][] tempTable = new String[table.size()][]; 

     int i = 0;
     for (List<String> next : table) {
      tempTable[i++] = next.toArray(new String[next.size()]); // return Object[][]
    }



   JTable EndTable = new JTable(tempTable,tempTitel);
public static void loadJadlospis() {
    List<String[]> ans1= null;
    MySQL.Connect();
    ans1 = MySQL.sqlQuery("SELECT NazwaJadlospisu FROM Jadlospis GROUP BY NazwaJadlospisu");
    MySQL.Close();
    List<String> rowsList = new ArrayList<>()   
    for(String[] rows: ans1) {
      for(String str: rows) {
         rowsList.add(str);
       }
    }   
    String[] comboData=rowsList.toArray(new String[0]);
    combo.setItems(comboData);  
}
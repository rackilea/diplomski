public void commandButton(){

     DBConn nCon=new DBConn();

     Calculations nCalc=new Calculations();
     nCalc.setPieChartSQL(getDate());
     nCon.setSQL(nCalc.getPieChartSQL());

     System.out.println("............");
     System.out.println(nCon.getResultSet());
     System.out.println("............");
     System.out.println(nCon.getResultSet());
     System.out.println("............");

     try {
         ResultSet rst=nCon.getResultSet();
         rst.beforeFirst();
         while(rst.next()){
             System.out.println("++++++++++++");
             String str=rst.getString(1);
             System.out.println("++++++++++++");
             setShowRes(str);
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }
    System.out.println("777777777777777777777");
}
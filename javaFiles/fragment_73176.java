if(StartDate==null && EndDate==null ){
    ResultSet rsDesignation=stmt.executeQuery("SELECT * FROM calcul WHERE designation='"+Designation+"' ");
    this.GetAttribut(calcul, rsDesignation);  
}  
if(Designation.equals(" ")){
    ResultSet rsDate=....; // The code above I wrote
    this.GetAttribut(calcul, rsDate); 
}
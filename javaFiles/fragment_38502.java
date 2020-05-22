if(rs.getRow()>0){
 String [] str = new String[res.getRow()];
 int i=0;
 while(res.next()){
   str[i++] = res.getString("EMP_IDNUM");
 }
}
JComboBox jcb = new JComboBox(str);
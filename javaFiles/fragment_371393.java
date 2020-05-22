try{
    Date joinDate = new Date();
    SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
    String join = "12/05/2012" ;
    joinDate = df.parse(join);
    System.out.println(joinDate);
}catch(ParseException e){
    // handle the ParseException
}
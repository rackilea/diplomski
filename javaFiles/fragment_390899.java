try{
    SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:SS");
    format.parse("55555");
    System.out.println("Correct date");
}catch(ParseException e){
    System.out.println("Incorrect date");
}
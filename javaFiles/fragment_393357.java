public String formatDate(String input){
    SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
    Date d = sdf.parse(input);
    sdf.applyPattern("EEEE, MMMM dd, yyyy");
    return sdf.format(d,new StringBuffer(),0).toString();
}
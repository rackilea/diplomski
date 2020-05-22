boolean validate(String input){
    try {
        new SimpleDateFormat(input).format(new Date());
        return true;
    }
    catch(Exception e) {
        return false;
    }
}
try{
..
}  catch (NoSuchElementException nse) {
    System.out.println ("Exception for the String Tokenizer");
}catch (NumberFormatException nfe) {
    System.out.println ("Exception for the Number format");
}
catch (Exception otherException) {
    System.out.println ( "Something else.. " + otherException.getMessage() );
}
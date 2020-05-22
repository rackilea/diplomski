try {
    int pos=str.indexOf('a');
    //Do something with pos...
} catch(CharacterNotFoundInStringException e) {
    System.out.println("Fail");
}
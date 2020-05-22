//constructor
    public Person(String myName, String[] myInput){
        String copy = new String[6];
        System.arraycopy(myInput, 0, copy, 0, myInput.length);
        choices = copy;
        name = myName;
    }
@Override
    public void addEntry(String line) throws IllegalArgumentException{

        int size = entries.length;

        String[] newLine = line.split("\\s+");
        if(newLine.length < 3)throw new IllegalArgumentException("Please provide a Surname, Initials and a Number");
        String surname = newLine[0];
        String initials = newLine[1];
        String number = newLine[2];

        if (surname.length()< 5 || initials.length()< 5 || number.length()< 5){
            throw new IllegalArgumentException("Please provide a Surname, Initials and a Number that is atleast 5 char long");
       //do other validations here like number -  is it a number or maybe has dashes and spaces

        }


        Entry newEntry = new Entry(surname, initials, number);
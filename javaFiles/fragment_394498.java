try {
    int number = Integer.parseInt(letter);
    if (number > 9 || number < 0) {
            Toast.makeText(this, "Number should be from 0 to 9",Toast.LENGTH_SHORT).show();
            return;
    }

    // number is correct, work with your number here    

} catch (NumberFormatException nfe) {
     Toast.makeText(this, "Unable to convert the string to number: " + letter,Toast.LENGTH_SHORT).show();
     return;
}
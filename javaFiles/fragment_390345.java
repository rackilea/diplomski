public void validator(String recognizeText) {

    Pattern emailPattern = Pattern.compile(EMAIL_PATTERN);
    Pattern phonePattern = Pattern.compile(PHONE_PATTERN);
    Pattern namePattern = Pattern.compile(NAME_PATTERN);

    String possibleEmail, possiblePhone, possibleName;
    possibleEmail = possiblePhone = possibleName = "";

    Matcher matcher;

    String[] words = recognizeText.split("\\r?\\n");

    for (String word : words) {
        //try to determine is the word an email by running a pattern check.
        matcher = emailPattern.matcher(word);
        if (matcher.find()) {
            possibleEmail = possibleEmail + word + " ";
            continue;
        }

        //try to determine is the word a phone number by running a pattern check.
        matcher = phonePattern.matcher(word);
        if (matcher.find()) {
            possiblePhone = possiblePhone + word + " ";
            continue;
        }

        //try to determine is the word a name by running a pattern check.
        matcher = namePattern.matcher(word);
        if (matcher.find()) {
            possibleName = possibleName + word + " ";
            continue;
        }
    }

    //after the loop then only set possibleEmail, possiblePhone, and possibleName into
    //their respective EditText here.

}
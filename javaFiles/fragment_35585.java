/* String to split. */
String stringToSplit = "primary%3ADownload%2FTest%20audio%20file.mp3";
String[] tempArray;

/* delimiter */
String delimiter = "%2F";

/* given string will be split by the argument delimiter provided. */
tempArray = stringToSplit.split(delimiter);

String result = tempArray[tempArray.length - 1];
result = result.replace("%20", " ");

fileNameDisplay.setText(result);
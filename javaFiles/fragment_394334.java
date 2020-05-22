String[] tokenize = fileRead.split(",");

String tempFirstN= tokenize[0];
String tempLastN = tokenize[1];
String tempMajor = tokenize[2];
String tempIdNo = tokenize[3];
String tempCourse = tokenize[4];
int tempCredits = Integer.parseInt(tokenize[5]);
double tempGpa = Double.parseDouble(tokenize[6]);  // !! 7 tokens !!
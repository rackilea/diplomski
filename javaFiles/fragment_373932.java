function checkCombo(String mletter) {
  String generatedLetter;
  switch(letter) {
    case "AB":
     generatedLetter = 'Z';// or you can set it to your textview here
     letter = ""; // if it goes inside any of your switch case clear your 
                     global variable
     break;
    case "DEF":
     generatedLetter = 'P'
     letter = "";
     break;
  }

}
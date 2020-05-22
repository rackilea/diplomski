string reDigit = "(?:one|two|three|four|five|six|seven|eight|nine)";
string reTeen = "(?:twenty|thirty|forty|fifty|sixty|seventy|eighty|ninety)";
string reTwoDigits = "(?:(?:" + reTeen + "-)?" + reDigit + "|ten|eleven|twelve|thirteen|fourteen|fifteen|sixteen|seventeen|eighteen|nineteen|" + reTeen + ")";
string reThreeDigits = "(?:(?:" + reDigit + " hundred (?:and )?)?" + reTwoDigits + "|" + reDigit + " hundred)";
string reSixDigits = "(?:(?:" + reThreeDigits + " thousand (?:and )?)?" + reThreeDigits + "|" + reThreeDigits + " thousand)";
string reTwelveDigits = "(?:(?:" + reSixDigits + " million (?:and )?)?" + reSixDigits + "|" + reSixDigits + " million)";

string reNumeric = "\\b(?:[0-9]+|" + reTwelveDigits + ")\\b";
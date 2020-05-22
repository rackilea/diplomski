Pattern p = Pattern.compile(yourRegex);
Matcher m = p.matcher(stringYouWantToTest);
if (m.find()){
    //tested string contains part which can be matched by regex
}else{
    //part which could be matched by regex couldn't be found
}
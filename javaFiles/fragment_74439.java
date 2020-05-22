public static char getOperator(String fileContent){

    int checkAdd = fileContent.indexOf('+');
    int checkMinus = fileContent.indexOf('-');
    int checkMulti = fileContent.indexOf('*');
    int checkDivi = fileContent.indexOf('/');

    if (checkAdd != -1){
        char operator = fileContent.charAt(checkAdd); 
        return operator;
    }   
    else if (checkMinus != -1) {
        char operator = fileContent.charAt(checkMinus);
        return operator;
    }
    else if (checkMulti != -1) {
        char operator = fileContent.charAt(checkMulti);
        return operator;
    }
    else if (checkDivi != -1){
        char operator = fileContent.charAt(checkDivi);
        return operator;
    }

    return ' ';
}
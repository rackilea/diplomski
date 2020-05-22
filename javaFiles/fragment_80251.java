public String longestSequenceOfChar(String str){
    String interimresult="";
    String result="";              //final result
    for(int i=0;i<str.length();i++){
        char ch=str.charAt(i);
        interimresult += ch;       //add the letter once
        for(int j=i+1;j<str.length();j++){
            char ch1=str.charAt(j);
            if(ch!=ch1){
                break;
            }
            interimresult +=ch;
        }
        if(interimresult.length()>result.length())//store the result if it is longer 
            result = interimresult;
        interimresult = "";                   //clear to continue with the next letter
    }
    return result;
}
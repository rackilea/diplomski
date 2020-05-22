String answer = "hello";
String hidden = answer.replaceAll(".", "*");  //let hidden fill with *

char guess = 'e';  //Get this from scanner

for(int x=0; x<answer.length(); x++)
    if(answer.charAt(x) == guess)
        hidden = hidden.substring(0,x) + guess + hidden.substring(x+1);
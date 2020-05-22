//compare strings instead of chars
String token = expressionAsTokens[j];
if (!"+".equals(token) && !"*".equals(token) && !"-".equals(token) && !"/".equals(token)) {
    s.push(Integer.parseInt(token)); 
} else {
    //same code as you had before
}
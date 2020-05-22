TOKEN :
{
< #DIGIT : [ "0"-"9" ] >
| < #ALPHABET: ["a" - "z"] >
| < #CAPSALPHABET: ["A" - "Z"] >
| < WORD: ( <DIGIT> | <ALPHABET> | <CAPSALPHABET>)+ >
}

String comment() :
{
  Token token;
}
{
 token=( <WORD> )+
 {
   return token.toString();
 }
}
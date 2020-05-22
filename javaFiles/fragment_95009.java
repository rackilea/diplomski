Instruction Instruction():{
    Instruction inst = new Instruction();
    Token o = null,dataType = null,calType = null,cmpType = null;
    Operand a = null,b = null; }
{
    ...
    o = <I_JPC> cmpType = <CMP_OP> a = Operand()
    ...
}

Operand Operand():{
    Token t ; ... }
{
     t = <T_REGISTER> ...
|    t = Identifier()  ...
    ...
}

Token Identifier : {
    Token t ; }
{
    t = <IDENTIFIER> {return t ;}
|   t = <I_CAL>      {return t ;}
|   t = <I_JPC>      {return t ;}
|   t = <CMP_OP>     {return t ;}
| ... // All other keywords
}
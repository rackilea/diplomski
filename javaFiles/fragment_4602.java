void Start(): { }
{
    <FUNCTION>
    <IDENTIFIER>
    {symttab.pushNewFrame() ;}
    <LBRACKET> Parameters()  <RBRACKET> 
    <LBRACE> Expression() <RBRACE>
    {symtab.popFrame() ; }
}
void Parameters() : {}
{
     ( Parameter() (<COMMA>   Parameter() )* )?
}
void Parameter() : {  Token x ; }
    <OBJECT> x=<IDENTIFIER>
    { if( symtab.topFrame().contains(x.image) ) reportError( ... ) ; }
    { symtab.topFrame().add(x.image) ; }
}
void Expression() : {  }
{
    Exp1() ( <PLUS> Exp1() )*
}
void Exp1() : { Token y ; }
{
    y = <IDENTIFIER>
    { if( ! symtab.topFrame().contains(y.image) ) reportError( ... ) ; }
|
    <NUMBER>
}
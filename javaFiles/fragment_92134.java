private X myFunction():
{
  X result = new X();
}
{

  <FUNCTION>
    <OPENPAR> 
                  son=expression() { result.params.add(son); }
       (  <COMMA> son=expression() { result.params.add(son); } )*
    <CLOSEPAR>
    { return result; }
}
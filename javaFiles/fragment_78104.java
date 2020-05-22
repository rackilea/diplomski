SKIP : { " " }
TOKEN : { < A : "-." > }
TOKEN : { < B : "-..." > }
TOKEN : { < C : "-.-." > }
...

String translate() :
{ StringBuilder sb; }
{
  { sb = new StringBuilder(); }

  (
    letter(sb)
  )*
  <EOF>

  { return sb.toString(); }
}

void letter(StringBuilder sb) :
{}
{
  ( <A>
    { sb.append('a'); }
  | <B>
    { sb.append('b'); }
  | <C>
    { sb.append('c'); }
  ...
  )
}
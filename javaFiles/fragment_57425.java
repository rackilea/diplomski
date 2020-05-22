options {
  static = true;
  debug_token_manager = true ; }

PARSER_BEGIN(MyNewGrammar)
package funnyunicode;
import java.io.StringReader ;

public class MyNewGrammar
{
  public static void main(String args []) throws ParseException
  {
    MyNewGrammar parser = new MyNewGrammar(new StringReader("日建フェンス工業"));
    MyNewGrammar.go() ;
    System.out.println("OK."); } }
PARSER_END(MyNewGrammar)

TOKEN :
{
  < WORD : (<LETTER>)+ >
|
  < #LETTER:
  [
   "\u0024",
   "\u0041"-"\u005a",
   "\u005f",
   "\u0061"-"\u007a",
   "\u00c0"-"\u00d6",
   "\u00d8"-"\u00f6",
   "\u00f8"-"\u00ff",
   "\u0100"-"\u1fff",
   "\u3040"-"\u318f",
   "\u3300"-"\u337f",
   "\u3400"-"\u3d2d",
   "\u4e00"-"\u9fff",
   "\uf900"-"\ufaff"
  ] >
}

void go() :
{Token tk ; }
{
  tk=<WORD> <EOF>
}
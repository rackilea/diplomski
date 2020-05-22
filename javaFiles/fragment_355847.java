import java.lang.System;
import java.util.Map;
import java.util.TreeMap;

class Sample {
  public static void main(String argv[]) throws java.io.IOException {
    Map<String,Integer> map = new TreeMap<>();

    Yylex yy = new Yylex(System.in);
    Yytoken t;
    while ((t = yy.yylex()) != null) {
      String text = t.mText;

      if (!text.isEmpty()) {
        Integer i = map.get(text);
        if (i == null) {
          map.put(text, 1);
        }
        else {
          map.put(text, map.get(text)+1);
        }
      }
    } 

    System.out.println(map);
  }
}

class Yytoken {
  public String mText;

  Yytoken(String text) {
   mText = text;
  }

  public String toString() {
    return "Token: " + mText;
  }
}

%%

OTHER=(.|[\r\n])

%% 

<YYINITIAL> "," { return (new Yytoken(yytext())); }
<YYINITIAL> ":" { return (new Yytoken(yytext())); }
<YYINITIAL> ";" { return (new Yytoken(yytext())); }
<YYINITIAL> "(" { return (new Yytoken(yytext())); }
<YYINITIAL> ")" { return (new Yytoken(yytext())); }
<YYINITIAL> "[" { return (new Yytoken(yytext())); }
<YYINITIAL> "]" { return (new Yytoken(yytext())); }
<YYINITIAL> "{" { return (new Yytoken(yytext())); }
<YYINITIAL> "}" { return (new Yytoken(yytext())); }
<YYINITIAL> "." { return (new Yytoken(yytext())); }
<YYINITIAL> "+" { return (new Yytoken(yytext())); }
<YYINITIAL> "-" { return (new Yytoken(yytext())); }
<YYINITIAL> "*" { return (new Yytoken(yytext())); }
<YYINITIAL> "/" { return (new Yytoken(yytext())); }
<YYINITIAL> "=" { return (new Yytoken(yytext())); }
<YYINITIAL> "<>" { return (new Yytoken(yytext())); }
<YYINITIAL> "<"  { return (new Yytoken(yytext())); }
<YYINITIAL> "<=" { return (new Yytoken(yytext())); }
<YYINITIAL> ">"  { return (new Yytoken(yytext())); }
<YYINITIAL> ">=" { return (new Yytoken(yytext())); }
<YYINITIAL> "&"  { return (new Yytoken(yytext())); }
<YYINITIAL> "|"  { return (new Yytoken(yytext())); }
<YYINITIAL> ":=" { return (new Yytoken(yytext())); }
<YYINITIAL> "#" { return (new Yytoken(yytext())); }
<YYINITIAL> {OTHER} { return (new Yytoken("")); }
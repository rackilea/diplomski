String s="";
String a="1234";
s=a.charAt(0)+s ==> s= "1" + "" = "1" ( + : concatenation )
s=a.charAt(1)+s ==> s='2'+"1" = "21" ( + : concatenation )
s=a.charAt(2)+s ==> s='3'+"21" = "321" ( + : concatenation )
s=a.charAt(3)+s ==> s='3'+"321" = "4321" ( + : concatenation )
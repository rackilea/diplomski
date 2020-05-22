parse
 : p1["param"]
 ;

p1 [String s]
 : ref=p2[$s, 42]
   {
     // Print some info about rule 'p2'.
     System.out.println("param=" + $s);
     System.out.println("p2.ss=" + $ref.ss);
     System.out.println("p2.ii=" + $ref.ii);
   }
 ;

// Rules can have more than 1 param, and can even return more than 1 value.
p2 [String s, int i] returns [String ss, int ii]
 : ID
   {
     $ss = $s + "_" + $ID.text;
     $ii = $i + $i;
   }
 ;

ID
 : ('a'..'z')+
 ;
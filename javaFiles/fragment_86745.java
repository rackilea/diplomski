grammar i;

@header {
 package i;
}


selects     : ( //test rule to allow processing multiple select calls. Don't worry about the details.
                {System.out.println(">>select");}
                select
                {System.out.println("<<select");}
               )+ 
            ; 

select      : 'SELECT *' 'FROM' table filters? ';'
              {System.out.println("\tFinished select.");}       //test output
            ;

module      : 'Module1'| 'Module2';
object      : 'I';
objectType  : 'Name';
filters     : 'WHERE' conditions
              {System.out.println("\tFinished filters.");}      //test output
            ;

table       : module object objectType
              {System.out.println("\tFinished table.");}        //test output
            ;

conditions  : STRING operator value
              {System.out.println("\tCondition test on " + $STRING.text);}
            ;
operator    : '=' | '!=';
true_       : 'true';       //changed so that Java code could be generated
value       : true_;
STRING      : ('a'..'z'|'A'..'Z')+;
WS          : (' '|'\t'|'\f'|'\n'|'\r')+ {skip();}; //ignore whitespace
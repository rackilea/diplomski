<DEFAULT> MORE: { "'" : INSTRING }
<INSTRING> MORE: { "\\\\" 
                 | "\\n" 
                 | "\\r"  
                 | "\\'"
                 | ~["\\","\n","\r","'"]
                 }
<INSTRING> TOKEN: { "'" : DEFAULT }
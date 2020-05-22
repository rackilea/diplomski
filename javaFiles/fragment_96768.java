variable-list =  varspec *( "," varspec )
 varspec       =  varname [ modifier-level4 ]
 varname       =  varchar *( ["."] varchar )
 varchar       =  ALPHA / DIGIT / "_" / pct-encoded

 modifier-level4 =  prefix / explode
 prefix        =  ":" max-length
 max-length    =  %x31-39 0*3DIGIT   ; positive integer < 10000
 explode       =  "*"
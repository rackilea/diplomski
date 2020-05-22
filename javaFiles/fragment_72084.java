period
 : years (',' months)? (',' days)? (',' hours)? (',' minutes)? (',' seconds)?
 | months (',' days)? (',' hours)? (',' minutes)? (',' seconds)?
 | ...
 | seconds
 ;

years
 : INTEGER YEARS 
 ;

months
 : INTEGER MONTHS
 ;

...

LIST_DELIM : ',';
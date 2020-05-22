// valid tokens first!
Number : [0-9]+;
Identifier : [a-zA-Z] [a-zA-Z0-9]*;
//...

// "error" tokens
// don't use these tokens in your grammar; They will show up as extraneous tokens during parsing and can be handled if desired.
InvalidIdentifier : [0-9]([0-9a-zA-Z])+; 
ACommonInvalidToken : '^'; // if you want to be more specific for certain cases
// add more to address common mistakes

UnknownToken : . ; // the "catch-all" error token; be sure not to be too greedy...
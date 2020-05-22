<DEFAULT> TOKEN : {
    <DIGIT : ["0"-"9"]>
}
<INBRACES> TOKEN : {
    <NUMBER : (["0"-"9"])+ >
}
<*> TOKEN {
    <LBRACE : "{" > : INBRACES 
|
    <RBRACE : "}" > : DEFAULT
|
    ...other rules apply in all states...
}
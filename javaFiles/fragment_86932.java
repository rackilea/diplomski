void Primary() : {}
{
    <INT> 
|
    "("
|
     {throw new ParseException("At "+getCoords()
                              +" there was \""+ getToken(1).image
                              + "\", but the parser expected either"
                              + " a \"(\" or an integer literal.");}
}
private String convertPsuedoFunctions(String mask)
{
    return 
         "function ifnotempty(value,sep){return value!=undefined&&value.length>0?value+sep:'';}"
         + mask;
}
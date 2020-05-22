public static String generateDynamicQueryForInAndValue(String sqlQuery, String stringList, String value1, String value2)
    {
        StringBuilder listWithBrackets = new StringBuilder();
        if(stringList == null || stringList.isEmpty()){
            stringList = "''";
        }else{

        stringList=stringList.replaceAll("^|$", "'").replaceAll(",", "','"); 
        }
        listWithBrackets = listWithBrackets.append('(').append(stringList).append(')');
        String value1WithQoutes = "'"+value1+"'";
        String value2WithQoutes = "'"+value2+"'";
         String finalQuery = sqlQuery.replace("@REPLACEMENT-IN@", listWithBrackets);
         finalQuery = finalQuery.replace("@REPLACEMENT-1@", value1WithQoutes);
         finalQuery = finalQuery.replace("@REPLACEMENT-2@", value2WithQoutes);
        return finalQuery;
    }
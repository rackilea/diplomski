private String generateWhereClause(){
    StringBuilder result = new StringBuilder();
    for (Long l : mAnsweredQuestions){
         result.append(" AND " + YOURID + " <> " + l);
    }
    return result.toString();
}
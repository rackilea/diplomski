List<Integer> getDowByTrmClassId(Integer trmClassId){
    . . . //Your other code here
    sqlQuery.setParameter("trmClassId", trmClassId);
    List<Integer> classDows = converToIngeter(sqlQuery.list()); //converToIngeter(list) was added to convert the result to Integer
    return classDows;       
}
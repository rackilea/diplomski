private List<List<String>> getAllCombinations(List<List<String>> lists)
{
    List<List<String>> result = new ArrayList<List<String>>();
    List<String> firstList = lists.get(0);
    List<List<String>> newParam = new ArrayList<>(lists);
    newParam.remove(0);
    if (!newParam.isEmpty()) {
        List<List<String>> midresult = getAllCombinations(newParam);
        for (String string : firstList) {
            for (List<String> list : midresult) {
                List<String> listNew = new ArrayList<>(list);
                listNew.add(0, string);
                result.add(listNew);
            }
        }
    } else {
        for (String string : firstList) {
            List<String> list = new ArrayList<String>();
            list.add(string);
            result.add(list);
        }
    }
    return result;
}
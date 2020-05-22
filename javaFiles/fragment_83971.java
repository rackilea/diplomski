private static Map<Integer, String> findMatches(String searchText, String dtoValue, int rowCount) {    
Map<Integer,String> matchesMap = new HashMap<Integer,String>();
if (dtoValue != null && dtoValue != "") {
        i = dtoValue.toLowerCase().indexOf(searchText, i+1);
        if(i>=0){
            newDtoData = dtoValue.replaceAll(searchText, "<span style='background-color: yellow; !important'>"+searchText+"</span>");
            matchesMap.put(rowCount, newDtoData);
            i = -1;
        }
    }
    return matchesMap;
...
for (List<String> ls : fnlData){    
    for (int j=0;j<ls.size();j++){
        ls.set(j, tmpListData.get(i).get(colOrder[j]));            
    }
    i++;
}
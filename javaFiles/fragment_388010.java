public ArrayList<String> compareLists(ArrayList<String> list1 , ArrayList<String> list2){

    ArrayList<String> resultList = new ArrayList<String>();

    for (String str : list1) {
        if(list2.contains(str)){
            resultList.add(str);
        }
    }

    return resultList;
}
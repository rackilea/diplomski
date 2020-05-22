ArrayList<ArrayList<Question>> lists= new ArrayList<>();
lists.add(new ArrayList<Question>());        

for(int i=0; i<fileList.size(); i++) {

    if(fileList.get(i).matches("^[|]+[|]+[|]+[1-9]+")) {
         lists.add(new ArrayList<Question>());
    } else {
        lists.get(lists.size() - 1).add(fileList.get(i));
    }

}
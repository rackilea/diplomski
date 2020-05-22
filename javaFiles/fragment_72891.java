ArrayList<Data> pList = new ArrayList<>();
separatedData.clear();
for (String name : projectnames) {
   pList.clear();
   for(Data data : allData){
        if (data.getProject().equals(name)){
             pList.add(data);

        }
    }
    seperatedData.add(pList);

}
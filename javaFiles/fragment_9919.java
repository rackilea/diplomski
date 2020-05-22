ArrayList<kovil> arrayList = new ArrayList<>();
arrayList.add(insertData1);
arrayList.add(insertData2);
for (int i=0; i<arrayList.size(); i++){
    dbhand.Add_Temple(arrayList.get(i));
};
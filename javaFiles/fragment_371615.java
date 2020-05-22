arrayList = new ArrayList<>();
arrayList1 = new ArrayList<>();
arrayList2 = new ArrayList<>();
// etc
Cursor res = myhelp.getAllData();
while (res.moveToNext()) {

        arrayList.add(res.getString(0));
        fa = arrayList.toArray(new String[0]);
        arrayList1.add(res.getString(1));
        fe = arrayList1.toArray(new String[0]);
        arrayList2.add(res.getString(2));
        fi = arrayList2.toArray(new String[0]);
        // etc

}
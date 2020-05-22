//I assumed here list 1 and 2 have the same sizes
List<Object> list1 = getList1();
List<Object> list2 = getList2();
int rNo = list1.size();
List<List<Object>> data = new ArrayList<List<Object>>(rNo);
int cNo = 2;
for(int i = 0; i < rNo; i++)
{
     List<Object> r = new ArrayList<Object>(cNo);
     r.add(list1.get(i));
     r.add(list2.get(i));
     data.add(r);
}
tm.setData(data);
List<String> originalList = new ArrayList<String>();
originalList.add("1234567");
originalList.add("6789034");
originalList.add("34534356");

List<String> modifiedList = new ArrayList<String>();

int listSize = originalList.size();
for(int i=0; i< listSize; i++)
{
    String str = "";
    str+="("+originalList.get(i)+")";
    if(i < listSize - 1)
        str+=",";
    modifiedList.add(str);
}

modifiedList.forEach(System.out::println);
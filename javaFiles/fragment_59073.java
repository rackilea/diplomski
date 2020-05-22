BufferedReader in = new BufferedReader(new FileReader("filepath"));
String str;

List<String> parts = new ArrayList<String>();
while ((str = in.readLine()) != null) {
        parts.add(str);
    }
List<String> newList = new ArrayList<String>();
List<String> emailPart=new LinkedList<String>();
List<String> numberPart=new LinkedList<String>();
for(int i=1;i<parts.size();i++){
    String[] strArr=parts.get(i).split("\\|");
    for(int j=0;j<strArr.length;j++){
        if(strArr[j].matches(".*@.*")){
            int index=strArr[j].indexOf("@");
            emailPart.add(strArr[j].substring(0, index).replaceAll("[A-Za-z0-9]", "X")+
                    strArr[j].substring(index, strArr[j].length()));
        }
        if(strArr[j].matches("[0-9\\-]+")){
            numberPart.add(strArr[j].replaceAll("[0-9]", "X"));
        }
    }
        newList.add(strArr[0]+"|"+emailPart.get(i-1)+"|"+numberPart.get(i-1));
}
System.out.println(newList);
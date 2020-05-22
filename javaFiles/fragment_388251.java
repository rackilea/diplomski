String str = "adc|def|efg||hij|lmn|opq";
String[] obj = str.split("\\|\\|");
    int i=0;
    String[][] names = new String[obj.length][]; 

    for(String temp:obj){
        names[i++]=temp.split("\\|");

    }
List<String[]> yourList = Arrays.asList(names);// yourList will be 2D arraylist.
System.out.println(yourList.get(0)[0]); // This will print adc.
System.out.println(yourList.get(0)[1]); // This will print def.
System.out.println(yourList.get(0)[2]); // This will print efg.
               // Similarly you can fetch other elements by yourList.get(1)[index]
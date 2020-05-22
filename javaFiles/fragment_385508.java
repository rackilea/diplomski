JSONArray arr = new JSONArray(); 
arr.put("foo");
arr.put("bar");

System.out.println(arr);//to show incorrect format

StringJoiner sj = new StringJoiner(" ");
for (int i = 0; i < arr.length(); i++){
    sj.add(arr.getString(i));
}
System.out.println(sj);
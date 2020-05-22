List<Character> code = new ArrayList<Character>();
code.add("A");
code.add("B");
code.add("C");


char[] list = new char[code.size()]; // Updated code

for(int i=0; i<code.size(); i++){
    list[i] = code.get(i);
    System.out.println(list[i]);
}
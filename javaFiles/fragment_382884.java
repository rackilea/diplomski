List<Integer> list = new ArrayList<>();
list.add(27576);
list.add(27600);
list.add(27624);
list.add(29952);

//Reverse the list
Collections.reverse(list);
List<Integer> result = new ArrayList<>();
for(int i=0 ; i<list.size() - 1 ; i++) {
    result.add(list.get(i) - list.get(i+1));
}
System.out.println(result);
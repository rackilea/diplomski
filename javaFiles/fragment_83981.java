List<String> list = new ArrayList<String>();

list.add("March");
list.add("January");
list.add("October");
list.add("April");

System.out.println("Before sort: " + list);
// prints: Before sort: [March, January, October, April]

new Months().sort(list); // sort

System.out.println("After sort: " + list);
// prints: After sort: [January, March, April, October]
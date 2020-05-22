String[] names = { "bobby", "jones", "james", "george", "cletus", "don", "joey" };
List<String> list = new ArrayList<String>(Arrays.asList(names));
Random random = new Random();   
int num = random.nextInt(names.length-1);    
list.remove(num);    
System.out.println(Arrays.asList(list.toArray(new String[list.size()])));  //Print the value of updated list
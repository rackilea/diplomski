Scanner input = new Scanner(System.in); 
System.out.println("Enter a number in word form: (Example: Five, Six, Seven): "); 

// wait for input
String number = input.next(); 

// display value, using Map#get method
System.out.println(String.format("You've entered %s which is integer %s", number, numbers.get(number)));  

// iterate over map entries using for (not while) loop
for (Map.Entry<String, Integer> e : numbers.entrySet()) {
    System.out.println(String.format("Number:%s, integer:%s", e.getKey(), e.getValue())); 
}
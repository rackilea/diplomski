final List<String> name = new ArrayList<String>();
final List<String> number = new ArrayList<String>();
name.add("Tommy"); // Test name
name.add("Tom"); // Test name 2
number.add(new String("123-456-7890")); // Test phone number
number.add(new String("098-765-4321")); // Test phone number 2

for (int i = 0; i < name.size(); i++) {
    System.out.println(name.get(i) + "\t\t" + number.get(i));
}
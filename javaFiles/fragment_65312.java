//Seed the constructor of class Random with the value 13.
Random rand = new Random(13);

//Create a collection and fill it with 20 random numbers between 1 and 15 (inclusive)

List<Integer> list1 = new ArrayList<>();

for (int i = 0; i < 20; i++) {
    list1.add(rand.nextInt(15) + 1);  // Note here
}

//Print the numbers

System.out.println(list1);

//Serialize the collection to a file called Numbers.ser

try (ObjectOutputStream out = new ObjectOutputStream(
        new FileOutputStream("Numbers.ser"))) {
    out.writeObject(list1);
} catch (IOException e) {
    e.printStackTrace();
}

//Deserialize the file into a new collection called numberFromFile. Remove all duplicate numbers
//this is where I am confused on how to deserialize. Can you someone explain this to me?
List<Integer> numberFromFile = null;
try (ObjectInputStream in = new ObjectInputStream(
        new FileInputStream("Numbers.ser"))) {
    numberFromFile = (List<Integer>) in.readObject();
} catch (Exception e) {
    e.printStackTrace();
}

//System.out.println(numberFromFile);

Set<Integer> distinct = new HashSet<>(numberFromFile); 
System.out.println(distinct);
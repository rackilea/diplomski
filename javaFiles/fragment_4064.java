// A List to hold all the names
List<String> namesList = new ArrayList<>();

// Create the full list of names
String[] names = {"mike", "Dragon", "jason", "freddy", "john", "mic"};

// Store them into the List
namesList = new ArrayList(Arrays.asList(names));

// Randomly get the first part of the name
int randomIndex = new Random().nextInt(names.length - 1);
String firstName = namesList.get(randomIndex);
String lastName = null;

// Figure out the size remaining
int remainSize = 12 - firstName.length();

// If desired, remove the element from the List so you don't get "DragonDragon"
namesList.remove(randomIndex);

// Randomly shuffle the list
long seed = System.nanoTime();
Collections.shuffle(namesList, new Random(seed));

// For each name, grab the first one that will complete the size 12
for (String name : namesList) {
    int nameSize = name.length();

    if (nameSize <= remainSize) {
        lastName = name;
        break;
    }
}

String newName = firstName + lastName;
System.out.println("Generated name: " + newName + ", with size " + newName.length());
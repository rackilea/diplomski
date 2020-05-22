import java.util.ArrayList;
System.out.println(How many times do you want to flip the coin?)
int flips = userinput.nextInt();
ArrayList<String> results;
if (flips == 5) {
    results = new ArrayList(5) // creates a list with 5 positons for Strings
} else {
    results = new ArrayLists(1) // creates a list with 1 position for String
}
results.set(0, "heads"); //sets the first flip to "heads"
System.out.println("The first flip was: " + results.get(0));
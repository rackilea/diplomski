public class Stack {

    int[] stack; // holds our list
    int MAX_SIZE, size; /* size helps us print the current list avoiding to 
                           print zer0es & the ints deleted from the list */    
    public Stack(int i) {
        MAX_SIZE = i; // max size makes the length configurable
        stack = new int[MAX_SIZE]; // intialize the list with zer0es
    }

    public static void main(String[] args) throws IOException {
        new Stack(2).run(); // list of max length 2
    }

    private void run() {
        Scanner scanner = new Scanner(System.in);
        // enter an infinite loop
        while (true) {
            showMenu(); // show the menu/prompt after every operation

            // scan user response; expect a 2nd parameter after a space " "
            String[] resp = scanner.nextLine().split(" "); // like "add <n>"
            // split the response so that resp[0] = add|list|delete|exit etc.
            System.out.println(); // and resp[1] = <n> if provided

            // process "add <n>"; check that "<n>" is provided
            if ("add".equals(resp[0]) && resp.length == 2) {
                if (size >= MAX_SIZE) { // if the list is full
                    System.out.print("Sorry, the list is full! ");
                    printList(); // print the list
                    continue; // skip the rest and show menu again
                }
                // throws exception if not an int; handle it
                // if the list is NOT full; save resp[1] = <n>
                // as int at "stack[size]" and do "size = size + 1"
                stack[size++] = Integer.parseInt(resp[1]);
                printList(); // print the list

            // process "list"
            } else if ("list".equals(resp[0])) {
                printList(); // print the list

            // process "delete"
            } else if ("delete".equals(resp[0])) {
                if (size == 0) { // if the list is empty
                    System.out.println("List is already empty!\n");
                    continue; // skip the rest and show menu again
                }
                // if the list is NOT empty just reduce the
                size--; // size by 1 to delete the last element
                printList(); // print the list

            // process "exit"
            } else if ("exit".equals(resp[0])) {
                break; // from the loop; program ends

            // if user types anything else
            } else {
                System.out.println("Invalid command!\n");
            }
        }
    }

    private void printList() {
        System.out.print("List: {"); // print list prefix

        // print only if any ints entered by user
        if (size > 0) { // are available i.e. size > 0
            int i = 0;
            for (; i < size - 1; i++) {
                System.out.print(stack[i] + ",");
            }
            System.out.print(stack[i]);
        }
        System.out.println("}\n"); // print list suffix
    }

    private void showMenu() {
      System.out.println("Enter one of the following commands:");
      // Check String#format() docs for how "%" format specifiers work
      System.out.printf(" %-8s: %s\n", "add <n>", "to add n to the list");
      System.out.printf(" %-8s: %s\n", "delete", "to delete the last number");
      System.out.printf(" %-8s: %s\n", "list", "to list all the numbers");
      System.out.printf(" %-8s: %s\n", "exit", "to terminate the program");
      System.out.print("$ "); // acts as command prompt
    }
}
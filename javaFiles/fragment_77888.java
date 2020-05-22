List<Integer> values = new ArrayList<>(25);
Integer value = null;
do {
    value = promptForInt("Please enter a series of integers. If you wish to stop, enter 'quit'. ", new Scanner(System.in), "quit");
    if (value != null) {
        values.add(value);
    }
} while (value != null);

System.out.println("You have input " + values.size() + " valid integers");
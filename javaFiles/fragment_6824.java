for (int i = 0; i < database.length; i++) {
    if (database[i] == item) {
        System.out.println("Item found at position: " + i);
        return i;
    }
}
System.out.println("Item not found.");
return -1;
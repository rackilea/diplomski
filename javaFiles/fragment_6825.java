public static int findItem(int item) {
    for (int i = 0; i < database.length; i++) {
        if (database[i] == item) {
            return i;
        }
    }
    return -1;
}

public static void main(String[] args) {
    int index = findItem(20);
    if (index >= 0) {
        System.out.println("Item found at position: " + index);
    }
    else {
        System.out.println("Item not found");
    }
}
for (int i = deleteIndex; i < phones.length - 1; i++) {
    phones[i] = phones[i + 1];
    // Move three lines of code
    phones[phones.length - 1] = null; // <= Problem here
    CellPhone[] newPhones = new CellPhone[phones.length - 1];
    // Need some code to copy data
    phones = newPhones;
}
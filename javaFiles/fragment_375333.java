public void addName(String name) {
    synchronized(this) {
        lastName = name;
        nameCount++;
    }
    System.out.println("a name has been added");
}
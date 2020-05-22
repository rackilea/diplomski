private static Student studentFromString(String studentRep) {
    String[] tokens = studentRep.split(" ");
    Student res = new Student(tokens[0], tokens[1], Integer.parseInt(tokens[2]), Integer.parseInt(tokens[3]));
    // You can ignore tokens[4] because you know how many files are submitted
    // by counting the remaining tokens.
    for (int i = 5 ; i != tokens.length ; i++) {
        res.getFileNames().add(tokens[i]);
    }
    return res;
}
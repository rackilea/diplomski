while (grades.hasNextLine()) {
    String line = grades.nextLine();
    String[] parts = line.split(" ");

    // get the basics
    String id = parts[0];
    String firstname = parts[1];
    String lastname = parts[2];

    // extract the grades
    int size = parts.length - 3;
    String[] gradelist = new String[size];
    System.arraycopy(parts, 3, gradelist, 0, size);

    // do something with the grades
}
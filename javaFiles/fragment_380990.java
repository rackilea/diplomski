//Writting
    ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream("person.out"));
    outputStream.writeObject(person);
    PrintStream pst = new PrintStream(outputStream);
    pst.append("Some static Value");

    outputStream.flush();
    outputStream.close();
    pst.close();

    // Reading
    ObjectInputStream in = new ObjectInputStream(new FileInputStream("person.out"));
    Perrson person=(Person) in.readObject();
    String staticText =in.readLine(); 
    in.close();
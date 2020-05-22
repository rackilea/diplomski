List<Ser> objTest2 = new ArrayList<Ser>();
while (testOS2.available > 0) {
    Ser toAdd = ((Ser)testOS2.readObject());
    toAdd.printIt(); 
    objTest2.add(toAdd);
}
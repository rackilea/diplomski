...
for(int i=0; i<50; i++){
    Person pers = new Person();
    out.print("name: ");
    pers.name=diskScanner.nextLine();
    out.print("stuff: ");
    pers.stuff=diskScanner.nextLine();
    thing.add(pers);
    break; //<-- Remove this to continue with the remaining 49 persons
}
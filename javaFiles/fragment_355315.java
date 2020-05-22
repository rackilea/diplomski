private void removeDog() {
    System.out.print("Enter the name of the dog ");
    String removeDogList = keyboard.nextLine();

    for (Iterator<Dog> dogsIterator = dogs.iterator();dogsIterator.hasNext();) {   
        Dog dog = dogsIterator.next();
        if (removeDogList.equals(dog.getName())) {
            dogsIterator.remove(); 
            System.out.println("The dog has been removed");
            return;
        } 
     }

     System.out.println("Nothing has been removed");
}
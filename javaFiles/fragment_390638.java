public void deleteDog(){
    System.out.print("Enter name of dog to delete: ");
    String nameOfDogToDelete = readString(); //returns the nextLine();
    boolean isFound = false; //To keep track of whether the dog is found or not
    for (Dog dl : dogRegister) {
        if (dl.getName().contains(nameOfDogToDelete)) {
            dogRegister.remove(dl); 
            System.out.println("Dog deleted.");
            isFound = true;
            break;//Break out of the loop as soon as you find it
        }
        // else //no need to check the negation of the above condition again
        //   System.out.println("Dog not found.");
        // }
    }
    if (!isFound)
         System.out.println("Dog not found.");
}
public static void main(String[] arg) {
    final Kennel kennel = new Kennel();
    DogBean[] allDogs = kennel.buildDogs();
    kennel.displayDogs(allDogs);
}

public void displayDogs(DogBean[] allDogs) {
    for(DogBean dogBean : allDogs) {
        System.out.println(dogBean); // TODO: make sure you implement the toString() method of DogBean.
    }
}
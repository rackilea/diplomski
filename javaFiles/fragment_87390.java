public static void main(String[] arg) {
    DogBean[] allDogs = new Kennel().buildDogs();
    displayDogs(allDogs);
}

public static void displayDogs(DogBean[] allDogs) {
    for(DogBean dogBean : allDogs) {
        System.out.println(dogBean); // TODO: make sure you implement the toString() method of DogBean.
    }
}
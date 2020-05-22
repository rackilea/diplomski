Salad mySalad = new Salad();
Optional<Salad> possibleSalad = set.stream().filter(mySalad::equals).findAny();
if (possibleSalad.isPresent()) {
    Salad alreadyExistingSalad = possibleSalad.get();
    // combine spices
} else {
    // add new salad
}
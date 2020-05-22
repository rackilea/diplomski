Dog dogToRemove = null;
for (Dog d: dogList) {
    if (d.getName().equals(userInput3)) {
        dogToRemove = d;
    }
}

if (dogToRemove == null) {
    System.out.println("Could not find dog with name " + userInput3);
} else {
    dogList.remove(dogToRemove);
}
Dog fido = new Dog("Fido");
for (Dog dog : dogs) {
  if (fido.equals(dog)) {  // Do the comparison this way round, since
                           // elements of list can be null in general.
    // Do whatever.
    break;  // Unless you want to do the same to all instances of Fido.
  }
}
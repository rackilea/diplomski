for (int i = 0; i < dogArrayList.size(); i++) {
    String dogName = dogArrayList.get(i).getName();
    if (name.equalsIgnoreCase(dogArrayList.get(i).getName())) {
        dogArrayList.get(i).increaseAge();
        System.out.println(dogArrayList.get(i).getName() + " is now " + dogArrayList.get(i).getAge() + " years old");
        break;
    }
}
// Only now, after the loop, we are sure that there is no dog with the given name.
System.out.println("Error: no dog called " + name);
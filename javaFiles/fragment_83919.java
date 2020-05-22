if (names.length != colors.length) {
    // error! not a 1:1 relationship
    return;
}
for (int i = 0; i < names.length && i < colors.length; i++) {
    String name = names[i], color = colors[i];
    Person d = new Person();
    d.setName(name);
    d.setColor(color);
    persons.add(d);
}
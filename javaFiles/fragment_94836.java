List<Cat> cats = session.createQuery(
    "from Cat where cat.name = ?")
    .setString(0, name)
    .list();
for ( Cat cat : cats ) {
    Cat mother = cat.getMother();
    ...
}
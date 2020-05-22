testWrite() {
    write(o);
    Object o2 = readByJdbc("SELECT * FROM table WHERE id = ?", o);
    assertObjectsEqual(o, o2); // this needs to compare all values
}

testRead() {
    write(o);
    Object o2 = read(o.id);
    Object o3 = readByJdbc("SELECT * FROM table WHERE id = ?", o);

    assertObjectsEqual(o2, o3); // this needs to compare all values
}
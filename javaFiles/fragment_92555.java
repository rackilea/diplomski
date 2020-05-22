public void iterate(SimpleEntity entity) {
    // you might want to add some logic here, that actually does something
    // with the current SimpleEntity instance you are iterating over
    for (SimpleEntity child : entity.getSimpleEntityChildren()) {
        iterate(child);
    }
}
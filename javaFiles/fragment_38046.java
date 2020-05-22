try (optionally with resources) {
    // stuff that throws FileNotFoundException and MyOwnCheckedException
}
// below exceptions are unrelated
catch (FileNotFoundException | MyOwnCheckedException e) {
    // TODO
}
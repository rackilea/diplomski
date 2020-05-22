try {
    instantiateWithFXMLLoader(entryClass, classLoader);
} catch (RuntimeException | IOException x) {
    status = JarReportEntry.Status.CANNOT_INSTANTIATE;
    x.printStackTrace(); // <-- print exception
} catch (Error | ClassNotFoundException x) {
    status = JarReportEntry.Status.CANNOT_LOAD;
    x.printStackTrace(); // <-- print exception
}
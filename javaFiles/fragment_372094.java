try {
    // you need to provide the default constructor!
    Object newInstance = Class.forName( "your.package.YourClassName" ).newInstance();
} catch ( ClassNotFoundException | IllegalAccessException | InstantiationException exc ) {
    exc.printStackTrace();
}
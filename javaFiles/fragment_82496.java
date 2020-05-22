try {
    App obj= new App();
    obj.main(null);
} catch(Exception e) {
    e.printStackTrace(); // good fall back if logging not implemented
}
Files.list((Paths.get("/some/path"))).map((someVal) -> {

    try {
        //do work with 'someVal'
    } catch (YourException ex) {
        //handle error
    }

});
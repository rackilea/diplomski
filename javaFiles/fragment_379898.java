try {
    ...
} catch(ProduktException e) {
    e.toString();
    if(e.isNotCreated()) {
        // do something
    }
    if(e.isNotDeleted()) {
        // do something
    }
}
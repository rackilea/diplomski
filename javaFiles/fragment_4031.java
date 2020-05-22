public boolean createzoo() {
    if(name != null) {
        this.zoo = new Zoo(name);
        return true; // Success
    } else {
        return false; // Failure
    }
}
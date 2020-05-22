public void createzoo() {
    if(name != null) {
        this.zoo = new Zoo(name);
    } else {
        throw new IllegalArgumentException("No name has been set for the zoo");
    }
}
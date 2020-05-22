ObjectifyService.run(new VoidWork() {
    public void vrun() {
        myObj = new MyObject();
        myObj.loadEverything();
    }
});
public void createBook(){
    create(new BSOInterfaceFactory());
}

public void create(BSOInterfaceFactory bsoInterfacefactory) {
    this.bsoInterface=bsoInterfacefactory.getBSOInterface();
    bsoInterface.createBook(this);
}
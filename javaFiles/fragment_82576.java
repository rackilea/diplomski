public Driver(Actions loc, Actions mess) {
    // use parameters to set fields so that the parameter references can be 
    // used elsewhere in the class
    this.loc = loc;
    this.mess = mess;

    System.out.println("sup nerd");
    yourmom(loc); // and pass references where needed
}
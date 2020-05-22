public Library(String name, int nrBookz) throws LibraryException {  
    if(nrBookz < 500){
        throw new LibraryException();
    }
    this.name = name;
    this.nrBookz = nrBookz;
    this.books = new Book[nrBookz]; // add this

}
void other( Object o ) { 
    // Cast needed:
    Funky f = ( Funky ) o;
    FunkySubClass fsc = ( FunkySubClass ) o;
    FunkySubClass fscII = ( FunkySubClass ) f;
    // Cast not needed:
    Object fobj = f; 
    Object fscobj = fsc; 
    Funky fparent = fsc;
}
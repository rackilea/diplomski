objSymbolPath = Paths.get(arystrAttr[1]);

if ( clsFolderTest.blnExists(Paths.get("/home/")) != true ) {
    System.out.println("doesn't exist!");
}
if ( clsFolderTest.blnExists(Paths.get("/home/plattens/")) != true ) {
    System.out.println("doesn't exist!");
}
if ( clsFolderTest.blnExists(Paths.get("/home/plattens/workspace/")) != true ) {
    System.out.println("doesn't exist!");
}
if ( clsFolderTest.blnExists(Paths.get("/home/plattens/workspace/jguids30ma/")) != true ) {
    System.out.println("doesn't exist!");
}
if ( clsFolderTest.blnExists(Paths.get("/home/plattens/workspace/jguids30ma/symbols/")) != true ) {
    System.out.println("doesn't exist!");
}
if ( clsFolderTest.blnExists(objSymbolPath) != true ) {
    clsMain.errMessage(clsSymbol.class.toString() + ":alstrToSVG"
                      ,"Symbol path does not exists or is not a folder!");
    return null;                                                            
}
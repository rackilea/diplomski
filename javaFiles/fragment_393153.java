try {
File f= new File("Buns.dat");
f.createNewFile();
}
catch(IOException ex){
ex.printStacktrace();
}
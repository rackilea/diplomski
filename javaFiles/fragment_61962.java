try{
    while(true) {
       Object obj=reader.readObject()
     // do sth with object
    }
}catch(EOFException e){
//we expect it so ignore
}
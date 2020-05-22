public void boo() throws IOException{
//something raising IOException
}

public void foo(){
  try{
      Sound obj = new Sound();
        obj.boo();
} catch(IOException io) {

//handle your exception
}
}
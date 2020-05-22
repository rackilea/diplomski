BufferedWriter output;
try {                
    File file = new File("/home/erik/glassfish3/"+selectedMss+".ini");

    //Providing true for second argument specifies it should be appended. 
    output = new BufferedWriter(new FileWriter(file,true));

    for(String newline: content){
        output.write(newline+"\n");      
    }

} catch ( IOException e ) {
       e.printStackTrace();
}finally{
  output.close();
}
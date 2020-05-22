while(Stream.Available() != 0); //block until there is data

try{  
    return in.readLine();  
} catch (IOException e) {  
    System.err.println("Send: Error on BufferedReader.readLine() - IOException");  
}
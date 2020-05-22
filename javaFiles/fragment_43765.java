String line;
while((line = reader.readLine()) != null){
    //now here process the line
    String[] args = line.split(" ");
    //and then your values
    int x = Integer.parseInt(args[0]);
    int y = Integer.parseInt(args[1]);
    int id = Integer.parseInt(args[2]);
    //and now create the card you should know how to do this 
    //And add the card to the board but I don't know how your game works exactly so I can't really help you here. 
    //But this code will be called for every card in the file
}
reader.close();
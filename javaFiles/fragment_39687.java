protected void sendMsg(String msg){
    try {
        for (ObjectOutputStream out2 : outList){
            out2.writeObject(msg + "\n");
            out2.reset();
        }//end of for each
    }//end of try
    catch(IOException ioe){}
}//end of sendMsg()
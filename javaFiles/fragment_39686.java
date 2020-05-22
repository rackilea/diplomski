protected void sendMsg(String msg){
    for (ObjectOutputStream out2 : outList){
        try {//try moved to this line
            out2.writeObject(msg + "\n");
        }//end of try
        out2.reset();//reset even if an error occurs so that the next message sends smoothly
    catch(IOException ioe){} //catch moved to this line
    }//end of for each
}//end of sendMsg()
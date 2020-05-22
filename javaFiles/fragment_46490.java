public void setMessageCode(InputStream location, String code){
    try {
        messagee = setMsg(location, code);
    } catch (IOException e) {
        e.printStackTrace();
    }
}

public String setMsg(InputStream location, String messageCode) throws IOException{
    String FILE = "assets/a.txt", msg;
    BufferedReader in = new BufferedReader(new InputStreamReader(location));
    msg = in.readLine();
    while(msg!=null){
        message = msg.split(",");
        for(int i=0; i<message.length; i++)
            if(message[i].equals(messageCode)){
                in.close();
                return message[i+1];
            }
        msg = in.readLine();
    }
    in.close();
    return "Nothing to get";
}
try(InputStream in = socket.getInputStream()){
     byte[] b = new byte[1024];
     String msg = "";
     for(int r;(r = in.read(b,0,b.length))!=-1;){
        msg += new String(b,0,r,"UTF-8");
     }
     System.out.println("Message from the client: " + msg);
}catch (Exception e) {
    e.printStackTrace();
}
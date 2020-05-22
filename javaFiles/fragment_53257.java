byte[] tmp=new byte[1024];
while(true){
  while(in.available()>0){
    int i=in.read(tmp, 0, 1024);
    if(i<0)break;
    System.out.print(new String(tmp, 0, i));
  }
  if(channel.isClosed()){
    System.out.println("exit-status: "+channel.getExitStatus());
    break;
  }
  try{Thread.sleep(1000);}catch(Exception ee){}
}
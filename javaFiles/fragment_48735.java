myHandler = new Handler()
{
     @OVerride
     public void handleMessage(Message msg)
     {
           if(((String)msg.obj).equals("enablebutton"))
           {
                //set all button enable here
           }
     }
}

...

Message msg = new Message();
msg.obj = "enablebutton";
GameHandler.this.myHandler.sendMessage(msg);     

...
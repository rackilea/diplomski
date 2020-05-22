String messagesToRead = "Me said: Hola\n"+
                    "Steven said: Hola android client\n"+
                    "Me said: como estas ?\n"+
                    "Steven said: Yo muy bien y tu?\n"+
                    "Me said: bueno si esto funciona me sentire magnifico ;)\n"+
                   "Me said: ah cierto me olvidaba veamos si dos mensajes seguidos funcionan\n"+
                   "Steven said: bien\nVeamos si funciona\n"+
                   "Me said: se xd\n";

            String[] messages= messagesToRead.split("\n");
            ArrayList<String> arr = new ArrayList<String>(Arrays.asList(messages));
            messages=null;
            String pattern1 = "Me said:";
            String pattern2 = "Steven said:";
            int size =  arr.size(); //you need to have the initial size before processing
             // lines you are talking about
             for(int i=size-1;i>=0;i--)
             {
                  String str = arr.get(i);
                  if(str!="" && str.indexOf(pattern1)==-1 && str.indexOf(pattern2)==-1)
                  {
                     String tmp = arr.remove(i);
                     String old =arr.get(i-1) ;
                     arr.set(i-1,old+"\n"+tmp);
                  }
             } 

            messages = new String[arr.size()];
            messages = arr.toArray(messages);

            for(String mess : messages)
            {
                if(mess!="" && mess.indexOf(pattern2) == 0)
                {
                     /*code here*/
                    System.out.println(mess);
                }
            }
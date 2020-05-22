jsonhandler handler = new jsonhandler();

try
   {
       return client.execute(request,handler);
   }catch(ClientProtocolException exception){
         exception.printStackTrace();
   }catch(IOException exception){
       exception.printStackTrace();
   }
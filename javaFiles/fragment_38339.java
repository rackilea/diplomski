HttpSevletRequest request = (HttpSevletRequest )getRequest.getContainerRequest();
try{
 InputStreamReader inputReader = new InputStreamReader(request.getInputStream());
    BufferedReader reader = new BufferedReader(inputReader );
    for(String line;(line = reader.readLine())!=null;){
        if(line.contains("abc")){
            //perform task....
     }
    }
}catch(IOException e){
 //logs
}
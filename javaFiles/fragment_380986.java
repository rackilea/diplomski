private String getOutput(Map<String, String> hm) throws UnsupportedEncodingException {

       String out = "";
       boolean start = true;

       for(Map.Entry<String, String> h : hm.entrySet()){
           if(start){

               start=false;
               out+=URLEncoder.encode(h.getKey(),  "UTF-8");
               out+="=";
               out+=URLEncoder.encode(h.getValue(), "UTF-8");
           }


           else{
               out += "&";
               out+=URLEncoder.encode(h.getKey(),  "UTF-8");
               out+="=";
               out+=URLEncoder.encode(h.getValue(), "UTF-8");
           }

       }
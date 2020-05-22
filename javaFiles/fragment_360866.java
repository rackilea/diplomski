String str_url= "http://www.google.com/";

String str_parms="#output="+URLEncoder.encode("search","UTF-8")+
                                   "&q="+URLEncoder.encode("nexus","UTF-8");

String str_final_url=str_url+str_parms;
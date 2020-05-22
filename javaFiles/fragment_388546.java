String str = "kushal,mayurv,narendra,dhrumil,mark, ,,,, ";
        String splitted[] = str.split(",");
        StringBuffer sb = new StringBuffer();
        String retrieveData = "";
        for(int i =0; i<splitted.length; i++){
            retrieveData = splitted[i];
            if((retrieveData.trim()).length()>0){

                if(i!=0){
                    sb.append(",");
                }
                sb.append(retrieveData);

            }
        }

    str = sb.toString();
    System.out.println(str);
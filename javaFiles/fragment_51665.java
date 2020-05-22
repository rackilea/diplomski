public String getShortName(String name){
        String[] token=name.split(" ");

        if(token.length>1){
            String value="";
            for(int i=0;i<token.length;i++){
                value+=token[i].substring(0,1);
            }
            return value;
        }else{
           return token[0].length()>1?token[0].substring(0,2):token[0];
        }

    }
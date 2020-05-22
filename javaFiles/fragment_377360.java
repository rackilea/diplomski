private String getSubDigit(int value, int postion){
        // you probably should check if the value is correct and ready to be processed.
        if(Check(value)) {
           String temp = "" + value;
           return temp.substring(position,position+1);
        }else{
           return "";
        }


    }
private static int stringLength(String string){
        if(string == null){
            return 0;
        }

        if(string.isEmpty()){
            return 0;
        }

        return 1 + stringLength(string.substring(1));
    }
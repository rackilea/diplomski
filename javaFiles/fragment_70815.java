private Integer returnCode(String p){
        int code = 0;
        String id = p.toLowerCase();
        if ("a".equalsIgnoreCase(id)) code = 3;
        else if ("b".equalsIgnoreCase(id)) code = 2;
        else if ("c".equalsIgnoreCase(id)) code = 1;
        //etc
        return new Integer(code);
 }
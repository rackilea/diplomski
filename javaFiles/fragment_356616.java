public  static HashMap stringToHashMap(String str)
    {
        int count=0;
        int equal_index=0;
        int commaindex=0;
        String key=null,val=null;
        HashMap map=new HashMap();
        int size=str.length();
        if(str.charAt(0)=='{' && str.charAt(size-1)=='}')
        {
        System.out.println("Valid-Map object");
        str=str.substring(1);
        size=size-1;
        while(size!=0)
        {
            equal_index=str.indexOf('=');
            if(equal_index==-1 && count==0)
                return null;
            key=str.substring(0,equal_index);
            str=str.substring(key.length()+1,size);
            size=size-(key.length()+1);

            commaindex=str.indexOf(",");
            if(commaindex==-1)
                commaindex=str.lastIndexOf('}');
            val=str.substring(0,commaindex);
            str=str.substring(val.length()+1,size);
            size=size-(val.length()+1);
            key=key.trim();
            val.trim();
            map.put(key, val);
            count++;
        }
        }
        else
            throw new RuntimeException("Invalid string format--Cannot convert it to map");
            return map;
    }
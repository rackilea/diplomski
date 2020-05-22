Map<String,ArrayList<String>> BasicNameValuePair = new LinkedHashMap<String,ArrayList<String>> ();

        ArrayList<String> v1 = new ArrayList<>();
        v1.add("5");
        v1.add("4");  
        BasicNameValuePair.put("items",v1);

        ArrayList<String> v2 = new ArrayList<>();
        v2.add("1.00");
        v2.add("50.00");  
        BasicNameValuePair.put("qty",v2);
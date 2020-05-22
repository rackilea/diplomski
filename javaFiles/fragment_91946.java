@Override
    protected Map<String, String> getParams() throws AuthFailureError {
        //put your map keys
        return checkParams(params);
    }

 private Map<String, String> checkParams(Map<String, String> map){               
        Iterator<Entry<String, String>> it = map.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry<String, String> pairs = (Map.Entry<String, String>)it.next();
            if(pairs.getValue()==null){
                map.put(pairs.getKey(), "");
            }
        }
        return map;             
    }
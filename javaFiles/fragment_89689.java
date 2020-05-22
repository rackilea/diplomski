ArrayList<HashMap<String,String>>  var = new ArrayList<HashMap<String,String>>();
    Collections.sort(var, new Comparator(){

        public int compare(Object o1, Object o2)
        {
            Map map1 = (Map) o1;
            Map map2 = (Map)o2;
            String name1 = (String) map1.get("name");
            String name2 = (String) map2.get("name");
            if(name1 != null){
            return name1.compareTo(name2);
            } else if(name2 != null){
            return name2.compareTo(name1);
            }else{
             return 0;
            }
        }
    });
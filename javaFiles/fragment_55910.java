LinkedHashMap<Group, List<Object>> hashMap=new LinkedHashMap<Group, List<Object>>();        

    for(Object model:objects){

            if(!hashMap.containsKey(model.getGroup())){
            List<Object> list= new ArrayList<Object>();
            list.add(model);
            hashMap.put(Group,list);
        }
        else{
            hashMap.get(model.getGroup()).add(model);
        }
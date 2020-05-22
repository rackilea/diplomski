for(int i=0; i<array_list.size(); i++){ 
    String obj = array_list.get(i); 
    System.out.println(obj);

    if(!obj.isEmpty()) {
        String o = obj.substring(1);
        System.out.println(o + obj);
    }
}
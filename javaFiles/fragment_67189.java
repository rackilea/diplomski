for(int i=0; i<array_list.size(); i++){ 
    System.out.println(array_list.get(i));

    if(!array_list.get(i).isEmpty()) {
        String o = array_list.get(i).substring(1);
        System.out.println(o + array_list.get(i));
    }
}
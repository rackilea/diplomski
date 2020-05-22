for(String ops : list21){

    if(sum_list.size()==0){
        sum_list.add(ops);
    }
    else{
         String str= ops.trim().replaceAll("[0-9]", "");
         String str_from_list=sum_list.get(sum_list.size()-1).replaceAll("[0-9]", "").trim();

         if(str_from_list.contains(str.trim())){
            System.out.println("found");
            int val= Integer.valueOf(sum_list.get(sum_list.size()-1).replaceFirst(".*?(\\d+).*", "$1"));
            int to_add = Integer.valueOf(ops.replaceFirst(".*?(\\d+).*", "$1"));
            int total = val+to_add;
            sum_list.set(sum_list.size()-1,total+" "+str_from_list);
         }
         else{
            sum_list.add(ops);  
         }
    }
System.out.println(sum_list);


}
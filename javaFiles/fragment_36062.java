for(String ops : list21){

    if(sum_list.size()==0){
        sum_list.add(ops);
    }
    else{
        String str= ops.trim().replaceAll("[0-9]", "");
        int index=-1;
        String str_from_list=null;
        for(String str_from_l : sum_list){
            str_from_list=str_from_l.replaceAll("[0-9]", "").trim();

            if(str_from_list.contains(str.trim())){
                index=sum_list.indexOf(str_from_l);
                break;
            }
        }


         if(index!=-1){
           // System.out.println("found");
            int val= Integer.valueOf(sum_list.get(index).replaceFirst(".*?(\\d+).*", "$1"));
            int to_add = Integer.valueOf(ops.replaceFirst(".*?(\\d+).*", "$1"));
            int total = val+to_add;

            sum_list.set(index,total+" "+str_from_list);
         }
         else{
            sum_list.add(ops);  
         }
    }



}
System.out.println(sum_list);
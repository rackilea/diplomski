public static ArrayList<String> fix(ArrayList<String> list) {
    // write your code here     
        //loop through array
    for (int i = 0; i < list.size();){
        //if contains r and not l -remove it
        if(list.get(i).contains("r") && !list.get(i).contains("l")){
                System.out.println(list.toString());
            list.remove(i);
          System.out.println(list.toString());
            if(i > 0) {i--;}    
        }
        //if contains l and not r - dub entry 
        if(!list.get(i).contains("r") && list.get(i).contains("l")){

          System.out.println(list.toString());
            list.add(i, list.get(i));
          System.out.println(list.toString());
            if(i == list.size()-1) {break;}else {i+=2;}
        }
        //contains none - do nothing
        if(!list.get(i).contains("r") && !list.get(i).contains("l")){

        }
        //contains both - do nothing
        if(list.get(i).contains("r") && list.get(i).contains("l")){

        }

      }



    return list;

 }
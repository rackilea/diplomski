public static String[] getDistinctives(String list[]){

    String [] samefirst = new String [list.length];


    for(int i = 0; i< list.length ; i++){
        int flag=0;
        for(int j = 0; j< list.length ; j++){   
            if( (list[i].charAt(0) == list[j].charAt(0)) && (i!=j) ){
                flag=1;
            }
        }

        if(flag==0) {
            System.out.println(list[i]);   
        }
    }
    return samefirst;
}
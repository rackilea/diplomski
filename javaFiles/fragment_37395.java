public static void sort (ArrayList<String> arr){    

    int N = arr.size();
    int E = N-1;
    String temp;
    boolean flag = true;

    while(flag){
        flag=false;

        for(int a = 0 ; a < E ; a++){
            if(Integer.parseInt(arr.get(a).substring(arr.get(a).indexOf(" ")+1)) > 
               Integer.parseInt(arr.get(a+1).substring(arr.get(a+1).indexOf(" ")+1))) {

                temp=arr.get(a);
                arr.set(a, arr.get(a+1));   
                arr.set(a+1, temp);

                flag=true;
            }   
        }
        E--;    
    }}
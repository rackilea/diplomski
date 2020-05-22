String[] arr = "1 3 5 6".split(" ");
    int[] intarr = new int[arr.length];

    for(int i = 0; i <arr.length; i++){
     intarr[i] = Integer.parseInt(arr[i]);
     if (prim(intarr[i]) == true){
         System.out.println(intarr[i]);

        }else{
            while (!prim(--intarr[i])){
            }
            System.out.println(intarr[i]);
        }
    }
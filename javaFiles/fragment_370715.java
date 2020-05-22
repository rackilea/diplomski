String[] arr = new String[5];
       arr[0]="2";
       arr[1]="3";
       arr[4]="5";
       for(int i=0; i<arr.length; i++){
           if(arr[i]==null){
               System.out.println(' ');
           }
           else {
               System.out.println(arr[i]);
           }
       }
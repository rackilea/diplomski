else{
        int a[] = new int [i+1];
        for(int j=0;j<i;j++){
            c++;
            a[j]=c;                 
        }
        for(int j=i-1;j>=0;j--){
           System.out.print(a[j]+" ");
        }

    }
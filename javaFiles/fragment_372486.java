public static void main (String args[]){



    int i=0,j=0,k=0;
    int count=0,temp=0,temp2=1;
    int a[]=new int[10];
    int max=a[0];
    Scanner sc= new Scanner(System.in);
    int n=sc.nextInt();
    while (i<n){
    a[i]=sc.nextInt();
    i++;
    }

    while(k<n){
       temp = a[k];//put input elements into in temp
      while (j<n){
       if(temp==a[j]){ //check if any repeated element found 
         count++; //increment
       }

        if(count>temp2){ //if element present more than once
          max = temp;
          temp2 = count;
        }
         j++;
      }
      k++;
    }

    System.out.println(max);
}
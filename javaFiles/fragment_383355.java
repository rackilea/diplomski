public static void main(String[] args) throws IOException
    {   BufferedReader br=new BufferedReader( new InputStreamReader(System.in));
    int A[]=new int[15];
    System.out.println("Input an array of 15 elements in descending order");
    for(int i=0;i<15;i++)
    {
        int j=Integer.parseInt(br.readLine());
        A[i]=j;
    }
    System.out.println("Input the number to be searched");
    int n=Integer.parseInt(br.readLine());
    System.out.println("Press 1 for Binary search");
    System.out.println("Press 2 for linear search");
    int ch=Integer.parseInt(br.readLine());


    switch(ch)
    {
    case 1:
    {
        int flag=0,low,up,mid=0;
        low=0;
        up=14;
        int count = 0;
        mid=(low+up)/2;
        while(low<=up)
        {

            if(n>A[mid]){
                                mid--;
                            }
            else if(n<A[mid]){

                mid++;
                            }
            else
            {

                flag=1;
            break;
            }
            count++;
        }
        System.out.println(count);
        if(flag==1)
            System.out.println("Element at position"+(mid+1));
        else 
            System.out.println("Element not found");
        break;
    }
    }
    }
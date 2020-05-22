Scanner input=new Scanner(System.in);
int[] ar1=new int[3];
int[] ar2=new int[3];

int evenIndex=0;
int oddIndex=0;
for(int i=0;i<ar1.length+ar2.length;i++){
    System.out.println("Enter number");
    int num=input.nextInt();

    if(i%2==0)// if the index is even number
    {
        ar1[evenIndex]=num;
        evenIndex++;
    }
    else{

        ar2[oddIndex]=num;
        oddIndex++;
    }
}

for(int i=0;i<ar1.length;i++)//print the result of array1
    System.out.print(ar1[i]+" ");

System.out.println();

for(int i=0;i<ar2.length;i++)//print the result of array2
    System.out.print(ar2[i]+" ");
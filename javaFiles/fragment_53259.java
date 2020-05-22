System.out.print("Enter How Many Inputs: ");
int num1 = Integer.parseInt(in.readLine());
int arr[] = new int[num1];

for (int i = 0; i<num1; i++)
{
    System.out.print("Enter Value #" + (i + 1) + ":");
    arr[i] =Integer.parseInt(in.readLine());
}
Random rand = new Random();
int[] list = new int[100];
int count = 1;

for (int i = 0; i < list.length; i++)
{
    list[i] =  rand.nextInt(500) + 1; 

    // check if you're at the 10th number in the line
    if (count % 10 > 0) System.out.print(list[i] + " "); // print on this line
    else System.out.println(list[i] + " "); // print on a new line
    count++;
}
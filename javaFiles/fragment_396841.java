Random rand = new Random();
List<Integer> list = new ArrayList<Integer>();
int count = 1;

for (int i = 0; i < 100; i++)
{
    list.add(rand.nextInt(500) + 1); 

    // check if you're at the 10th number in the line
    if (count % 10 > 0) System.out.print(list.get(i) + " "); // print on this line
    else System.out.println(list.get(i) + " "); // print on a new line
    count++;
}
Random rand = new Random();
int RandNum = 0;
float average = 0;

for(int i =0; i < 3; i++)
{
    RandNum = rand.nextInt(50);
    System.out.println(RandNum);
    average = average+RandNum;
}

average = average/3;
System.out.println(average);
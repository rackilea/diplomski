Random random = new Random();
double start = -x;
double end = x;
for (int i=0;i<numPointsA;i++)
{
    double ran = random.nextDouble();
    double result = start + (ran * (end - start));
    System.out.println(result);
}
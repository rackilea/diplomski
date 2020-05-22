int maxS = height;
for (int row = 1; row <= maxS; row ++)
{
    for (int star = maxS - row + 1; star >= 1; star--)
    System.out.print("* ");
    System.out.println();
}
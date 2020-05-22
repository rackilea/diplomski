int num = 128;
while (num > 1) // This takes care of the loop. 
                //Also if you write num = 256, then also this loop would work.
{
    num = num / 2;

    System.out.print(num);
    System.out.print(", ");         
}
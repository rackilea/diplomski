int homeruns;
do
{
    System.out.print("Enter the number of home runs from each team: ");
    //int homeruns = in.nextInt();
    homeruns = in.nextInt();
    if(homeruns > 0)
    {

        hrs = hrs + homeruns;
        count++;

    }
}
while(homeruns != SENTINEL);
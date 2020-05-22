for (int i= 1; i<=n; i++)
{
    ...//Calculating the perimeter

    if (perimeter < min){
       ..//do whatever you want
       min= (double) perimeter;
       smallTra = i;
    }
    .. //do whatever you want
}
System.out.printf("The minimum perimeter of traingle "+smallTra+ " is: %.1f %n" , min);
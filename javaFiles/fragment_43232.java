float total = 0;
for(Inventory i: a1)
{
     total += i.getTotal();
     //if you want to print for every item, otherwise remove below line
     System.out.println(i)
}
System.out.println("The total is " + total); // This will just print one line 
                                             // with the total of the entrie list
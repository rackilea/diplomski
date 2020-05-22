double bronCost = bron.calcDayTimeCost(0.12);
double silverCost = silv.calcDayTimeCost(0.22);
if(bronCost == silverCost) {
    System.out.print("\nThe Silver and Bronze Accounts are same cost ");
} else if (bronCost < silverCost){ 
     System.out.print("\nThe Bronze Account is cheapest.");
} else {
     System.out.print("\nThe Silver Account is cheapest.");
}
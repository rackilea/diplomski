public void displayAverageWeight()
{
   double hold;
   int count;
   for(Packet mypacket : shipmentList)
   {
       hold += mypacket.weight;
       count++; 
   }
   System.out.println("The average weight is " + hold / count);
}
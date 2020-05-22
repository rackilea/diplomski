for (int i =0; i<  theseSocks.size(); i++)
{
   String currentSock = theseSocks.get(i);
   if (currentSock.equals(ipAddress))
   {
       System.out.println("the element is " +currentSock);
       break;
   }
}
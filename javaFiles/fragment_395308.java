for(int i=0;i<(1<<16);i++)
{
 //i represents a subset
 for(int j=0;j<16;j++)
   if(i & (1<<j))
   {
    //j-th packet is present in subset
   }
}
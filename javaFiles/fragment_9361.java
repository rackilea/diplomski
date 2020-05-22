int num=103;
for(l=num+1;;l++)
{
   if(l%10==1)
   {
    for(k=2;k<l;k++)
    {
     if(l%k==0)
        break;
     }
     if(k==l)
     {
       System.out.println("Next prime no is:"+l);
       break;
     }
   }
}
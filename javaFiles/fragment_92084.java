String val=input.nextLine();
j1=0;
if(val!=null){

   if(val.contains(","))
   {
       String str[]=val.split(",");
       int cn=str.length;
       while(cn>0)
       {
           Data[i1][j1]=str[j1];
           cn--;
           j1++;
       }
     }else
        Data[i1][j1]=val;
     i1++;
 }
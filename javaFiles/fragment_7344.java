String S=et1.getText().toString();
   int i,a=0, sum=0;
   i=Integer.parseInt(S);          
   while(i!=0)
   {
       a=i%10;
       i=i/10;
       sum=sum+a;
   }
   System.out.println(sum);
   if(sum==13||sum==14||sum==16||sum==19)
   {
       System.out.println("match");
   }
   else
   {
       System.out.println("not match");
   }
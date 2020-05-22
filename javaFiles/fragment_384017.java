public void Factorization(double n)
 {
     for(i=1;i<=n;i++)
     {
        if(n%i==0) 
        {
             n1=n/i;
             String First,Second;
             First=Double.toString(n1);
             Second=Double.toString(i);
             String Factor = First + "x" + Second; 
             Arrangement.addItem(Factor);
        }
    }
}
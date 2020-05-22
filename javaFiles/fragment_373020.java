double investmentAmount; //the amount the user chooses to invest, expressed as a double
   investmentAmount = Double.parseDouble(InputInvestmentAmount);
   Double OrginalInvestment; 
   OrginalInvestment=investmentAmount;//this is too keep your orginal investment
   double Interest; // amount of interest in percent, expressed as a double
   Interest = Double.parseDouble(InputInterest);
   double YearsInvested; //the total years (under 15) the user wants to invest, expressed as a double
   YearsInvested = Double.parseDouble(InputYearsInvested);
   double Zero = 0; //a starting point for the year
   double Total;
    System.out.println("Years Invested \t\tAmount in Account\t\tInterest\t\tTotal");
   if (YearsInvested >=16)
   {
       JOptionPane.showMessageDialog(null,"I am sorry. Please make sure that you are investing your money for "
               + "less than 16 years.", "Compound Investing Calculator",JOptionPane.ERROR_MESSAGE);
   }
   double IntrestMoney;
   do {
       Zero++; //the year

        IntrestMoney = investmentAmount*(Interest/100);
        Total = investmentAmount+IntrestMoney;

       System.out.format("%5.2f%32f%28f%25f%n",Zero,investmentAmount,IntrestMoney,Total);
       investmentAmount=Total+OrginalInvestment; //
   }
   while (YearsInvested <= 15 && Zero<=YearsInvested-1); 

 }
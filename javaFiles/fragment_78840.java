for (int h = 1; h <= 5; h++) {
    InvestmentAmount *= 1 + InterestRate / 100;
    System.out.print(h);
    System.out.printf("          %4.2f",  InvestmentAmount);
    System.out.println("      ");
  }
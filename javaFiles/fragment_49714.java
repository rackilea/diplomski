final AvgCalculator avgCalc = new AvgCalculator();

avgCalc.calcNewAvg(1);
avgCalc.calcNewAvg(3);
avgCalc.calcNewAvg(1);
avgCalc.calcNewAvg(3);
System.out.println(avgCalc.getAvg);  // should print 2  (1+3+1+3 = 8    8/4 = 2)

avgCalc.resetAvg();
System.out.println(calcNewAvg(5));   // should print 5  (5/1 = 5)
System.out.println(calcNewAvg(15));  // should print 10 (5+15 = 20  20/2 = 10)
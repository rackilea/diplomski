int runs = 100*1000;
for(int i = -20000 /* warmup */; i < runs; i++) {
   if(i == 0)
       beginTime = System.nanoTime();
   Lehman.getFullFactorization(numberStr);
}
finishTime = System.nanoTime();
System.out.println("Average time was " + (finishTime-beginTime)/1e9/runs. + " sec.");
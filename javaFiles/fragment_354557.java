long start = System.currentTimeMillis();

driver.get("Some url");

long finish = System.currentTimeMillis();
long totalTime = finish - start; 
System.out.println("Total Time for page load - "+totalTime);
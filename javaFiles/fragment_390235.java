long nanoStart = System.nanoTime();
long milliStart = System.currentTimeMillis();

Thread.sleep(2000);

long nanoEnd = System.nanoTime();
long milliEnd = System.currentTimeMillis();;

long nanoDelta = nanoEnd - nanoStart;
long milliDelta = milliEnd - milliStart;

System.out.println((double) nanoDelta / milliDelta);
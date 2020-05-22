int runs = 10000000;
String val = "" + Math.PI;
long start = System.nanoTime();
for (int i = 0; i < runs; i++)
    Float.parseFloat(val);
long time = (System.nanoTime() - start) / runs;
System.out.println("Average Float.parseFloat() time was " + time + " ns.");

long start2 = System.nanoTime();
for (int i = 0; i < runs; i++)
    Double.parseDouble(val);
long time2 = (System.nanoTime() - start2) / runs;
System.out.println("Average Double.parseDouble() time was " + time2 + " ns.");
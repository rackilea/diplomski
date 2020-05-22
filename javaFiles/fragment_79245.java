double ratio = 1.778;
double bestDelta = Double.MAX_VALUE;
int bestI = 0;
int bestJ = 0;

for (int i = 1; i < 100; i++) {
  for (int j = 1; j < 100; j++) {
    double newDelta = Math.abs((double) i / (double) j - ratio);
    if (newDelta < bestDelta) {
      bestDelta = newDelta;
      bestI = i;
      bestJ = j;
    }
  }
}

System.out.println("Closest ratio: " + bestI + "/" + bestJ);
System.out.println("Ratio        : " + ((double) bestI / (double) bestJ));
System.out.println("Inaccurate by: " + bestDelta);
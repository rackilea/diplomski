double[] values = {2,3,4,5,6,7};

double min = values[0];
double max = values[0];
double sum = 0;

for (double value : values) {
     min = Math.min(value, min);
     max = Math.max(value, max);
     sum += value;
}

double avg = sum / values.length;

System.out.println("Min: " + min);
System.out.println("Max: " + max);
System.out.println("Avg: " + avg);
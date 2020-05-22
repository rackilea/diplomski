double a = Double.parseDouble("011490.2");
double b = Double.parseDouble("011500.1");
int count = 0;
while (a <= (b + 0.1)) {
    System.out.printf("printing range: 0%.1f\n",a);
    a = a+0.1;
}
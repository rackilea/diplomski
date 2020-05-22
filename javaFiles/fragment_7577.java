Scanner in=new Scanner (System.in);
double num[]=new double[5];
double average=0;
int i=0;
double sum=0;

double min = Double.MAX_VALUE;
double max = Double.MIN_VALUE;

for (i=0;i<num.length;i++) {
    System.out.println("enter a number");
    num[i]=in.nextDouble();
    sum=sum+num[i];
    if (num[i]<min) {
        min=num[i];
    } else if (num[i] > max) {
        max=num[i];
    }
}

average=sum/num.length;
System.out.println(String.format("Average=%.3d", average));
System.out.println(String.format("Min=%.3d", min));
System.out.println(String.format("Max=%.3d", max));
System.out.println(String.format("Sum=%.3d", sum));
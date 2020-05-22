List<double[]> list = new ArrayList<>();

double[] a = new double[] { 1.0, 2.0 };
double[] b = new double[] { 3.0, 4.0 };

// Three new's: three objects.

list.add(a);
list.add(a);
list.add(b);

a[0] = 5.0;
list.get(0)[1] = 6.0;

// list: [ [5.0, 6.0]==a, [5.0, 6.0]==a [3.0, 4.0]==b ]
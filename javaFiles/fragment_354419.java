int a[] = { 1, 2, 3, 4, 5, 6, 7, 8, 9 }; // <-- declare an array.
int min = a[a.length - 1];               // <-- set an initial min.
int max = a[0];                          // <-- set an initial max.
if (min > max) {                         // <-- check if they're reversed,
  min = a[0];                            //     if so swap them.
  max = a[a.length - 1];
}
for (int i = 1; i < a.length - 1; i++) { // <-- loop
  if (a[i] < min)                        // <-- is a[i] less then min,
    min = a[i];                          //     if so update min.
  if (a[i] > max)                        // <-- is a[i] greater then max,
    max = a[i];                          //     if so update max.
}
System.out.printf("min = %d, max = %d%n", min, max);
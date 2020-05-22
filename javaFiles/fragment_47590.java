int a = 323, b = 322;

// Get the size of the array
int n = a + b;
int size = 0;
while (n > 0) {
    size++;
    n = n / 10;
}

// Build the output
int s[] = new int[size];
n = a + b;
for (int i = size - 1; n > 0; i--) {
    s[i] = n % 10;
    n = n / 10;
}

// Print
for (int x : s) {
    System.out.println(x);
}
int n1 = (int) (Math.random() * 10) + 1;
int n2;
do {
    n2 = (int) (Math.random() * 10) + 1;
} while (n2 == n1);
int n3;
do {
    n3 = (int) (Math.random() * 10) + 1;
} while (n3 == n2 || n3 == n1);
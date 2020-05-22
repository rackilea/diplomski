long n12 = (int) (upc%10);
upc /= 10;
long n11 = (int) (upc%10);
upc /= 10;
long n10 = (int) (upc%10);
upc /= 10;
long n9 = (int) (upc%10);
upc /= 10;
long n8 = (int) (upc%10);
upc /= 10;
long n7 = (int) (upc%10);
upc /= 10;
long n6 = (int) (upc%10);
upc /= 10;
long n5 = (int) (upc%10);
upc /= 10;
long n4 = (int) (upc%10);
upc /= 10;
long n3 = (int) (upc%10);
upc /= 10;
long n2 = (int) (upc%10);
upc /= 10;
long n1 = (int) (upc%10);



int m = (n2 + n4 + n6 + n8 + n10);
long n = (n1 + n3 + n5 + n7 + n9 + n11);
long r = (10-(m+3*n)%10);
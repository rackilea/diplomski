// print header (n   n%1 n%2 etc.)
System.out.print("n");
for (int denom = 1; denom <= max_denom; denom++)
    System.out.print("\tn%"+denom);
System.out.println();

// print table
for (int numer = 1; numer <= max_numer; numer++) {
    System.out.print(numer);
    for (int denom = 1; denom <= max_denom; denom++) {
        System.out.print("\t" + numer%denom);
    }
    System.out.println();
}
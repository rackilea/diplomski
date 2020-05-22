int prev = x.nextInt();
for (i=0; i<k-1; i++) { 
    j = x.nextInt();
    if (j < prev) { System.out.print("Not Growing Up."); return; }
    prev = j;
}
System.out.print("Growing Up.");
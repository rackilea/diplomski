n = x.nextInt(); 
for (i=0; i<n-1; i++) { 
    j = x.nextInt();
    if( j < n) { 
        asc++;              // is this right?
    } else {
        asc--;
    }
}
if (asc==k) {
    System.out.print("Not Growing Up."); 
} 
if (asc!=k) { 
    System.out.print("Growing Up.");
}
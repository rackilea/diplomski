int x[] = new int[5]
Random t = new Random();
for (e = 1; e <= 5; e++) {
    x[e] = t.nextInt(1000); // you didn't even assign any variables to sort, that's one problem, you just printed them.
} // and idk how you get random int's in java, but if this doesn't work, just make your own random int generator.
  // There's LOTS of better ones than the one your using now.

int temp, q, w;

for(int i=0;i< 5;i++) { 
    for(int j=0;j<5-i;j++) {
        if(q[j]>q[j+1]) {
            temp = q[j-1];
            q[j-1] = q[j];
            q[j] = temp;
        } 
        // Add 'else ifs' here
    }
}

for (int i = 0; i < 5; i++) { // and this will print the results
    System.out.print(q[i] + " ");
}
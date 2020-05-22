String line1 = ... // your line 1
String line2 = ... // your line 2
Scanner s1 = new Scanner(line1); 

int i1 = 0;
while (s1.hasNext()) {
    String token1 = s1.next();
    Scanner s2 = new Scanner(line2);

    int i2 = 0;
    while (s2.hasNext()) {
        String token2 = s2.next();

        // now you have token1, token2 and their positions (i1, i2)
        // do whatever you want with them

        i2++;
    } // end reading line2
    i1++;
} // end reading line1
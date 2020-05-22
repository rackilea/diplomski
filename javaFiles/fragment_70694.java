int greatest = 0;
int max = -1;
//int numChar = Integer.parseInt(num.substring(0, 5)); <-- Not Here

for (int i = 0; i < num.length() - 5; i++) {
    int numChar = Integer.parseInt(num.substring(i, i + 5)); //  <-- but here
    greatest = numChar;

    if (max < greatest) {
        max = greatest;
    }
}
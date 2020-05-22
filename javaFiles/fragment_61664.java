Scanner tri = new Scanner(System.in);
System.out.println("Enter a postive integer.");
int shape = tri.nextInt();

for (int c = shape; c >= 1; --c) {
    for (int a = 1; a <= c; a++) {
        System.out.print(" ");
    }
    for (int d = c; d <= shape; d++) {
        System.out.print(d);
    }
    System.out.println(" ");
}

// result
//     5 
//    45 
//   345 
//  2345 
// 12345
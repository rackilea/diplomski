char ltr = 'A';
for (int i = 0; i < N; i++) {

  // Print the leading spaces.
  int nLeadingSpaces = N - i - 1;
  for (int j = 0; j < nLeadingSpaces; j++) 
    System.out.print(' ');

  // Print the letters for this row.  There are
  // i+1 of them. So print the first i with a following
  // space and the last one with a newline.
  for (int j = 0; j < i; j++) 
    System.out.print(ltr++ + " ");
  System.out.println(ltr++);
}
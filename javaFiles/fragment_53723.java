int n = 5;

// We go line by line
for (int line=0; line<n; line++) {

    // Calculate number of spaces in the line. Number of spaces on the 
    // right hand side is always the same as the number on the left hand side
    int spaces = n - line;

    // We have twice as much digits in each line as the line index plus one 
    // digit (because we always have an odd number of digits). 
    int digits = 2*line + 1;

    // Print left spaces
    for (int i=0; i<spaces; i++) {
        System.out.print(" ");
    }

    // Print digits. This does the trick.
    for (int i=0; i<digits; i++) {
        // The key for the algorithm is this symmetrical triangle. We will use 
        // digits/2 - i expression, which prints out the following triangle
        //      0
        //    1,0,-1
        //  2,1,0,-1,2
        // etc.
        //
        // Now we need to get rid of minus sign by using Math.abs function
        // and add number of spaces decreasing with every new line and 
        // compensating increasing digits in the triangle.
        System.out.print(spaces + Math.abs(digits/2 - i));
    }

    // Print right spaces. We may omit this, as right spaces are not 
    // visible and they have no impact on the shape.
    for (int i=0; i<spaces; i++) {
        System.out.print(" ");
    }

    // Finish the line
    System.out.println();
}
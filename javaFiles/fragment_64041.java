int maxTries = 3;
int count = 0;

while (!scan.hasNextInt()) {
    if (++count == maxTries) {
        // Maximum Attempt reached.
        // throw some exception
    }

    System.out.print ("reenter as integer: ");        
    scan.next();  // Move cursor past current input
}

num = scan.nextInt();
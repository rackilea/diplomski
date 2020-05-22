// This will print "continue" forever.
CONTINUE_LOOP:
while(true) {
    System.out.println("continue");
    continue CONTINUE_LOOP;
}

// This will only print "break" once and then break out of the loop
BREAK_LOOP:
while(true) {
    System.out.println("break");
    break BREAK_LOOP;
}
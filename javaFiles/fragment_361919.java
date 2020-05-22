boolean blankLine = true;
loop:
while (true) {
    int available;
    while ((available = System.in.available()) == 0) {
        // Do something
    }
    do {
         switch (System.in.read()) {
             default:
                 blankLine = false;
                 break;
             case '\n':
                 if (blankLine)
                     break loop;
                 blankLine = true;
                 break;
         }
    } while (--available > 0);
}
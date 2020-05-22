boolean hasQuit = false;
do {
    f = sc.next(); // assigns the first standard input to f (can either be ? or quit)
    g = sc.next(); // assigns the second word from standard input to g (can either be perimeter or area)
    if (f.equals(sQues)) { // if first word is equal to "?" then the if statements continue
        if (g.equals(sQuit)) {
            hasQuit = true;
        } else if (g.equals(sPeri)) { // if the second word is equal to "perimeter" print out result
            //...
        } else if (g.equals(sArea)) { // if the second word is equal to "area" print out result
            //...
        }
    }
} while (!hasQuit);
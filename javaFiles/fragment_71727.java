boolean mod3 = printNumber % 3 == 0;
boolean mod5 = printNumber % 5 == 0;
boolean mod7 = printNumber % 7 == 0;
if (mod3 || mod5 || mod7) {
    if (mod3 && mod5 && mod7) {
        System.out.print("cheesecakefactory");
    } else {
        boolean isCheck4 = check4(printNumber); // <-- call it once
        if (mod3 && mod5) {
            System.out.print("cheesecake");
        } else if (mod3 && mod7) {
            System.out.print("cheesefactory");
        } else if (mod5 && mod7) {
            System.out.print("factorycake");
        } else if (mod3) {
            System.out.print("cheese");
        } else if (mod5) {
            System.out.print("cake");
        } else if (mod7) {
            System.out.print("factory");
        } else {
            if (!isCheck4) { // <-- it doesn't have a 4, print it.
                System.out.print(printNumber);
            }
        }
        if (isCheck4) {
            System.out.print("hoho"); // <-- it does have a 4.
        }
    }
}
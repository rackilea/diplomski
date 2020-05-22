ch1 = (char) System.in.read();
System.in.skip(1);//Skip the next keystroke, which is enter
switch(ch1) {
    case 'A':
        System.out.println("This A is part of outer switch.");
        ch2 = (char) System.in.read();
//                ch2 = 'A';
        switch(ch2) {
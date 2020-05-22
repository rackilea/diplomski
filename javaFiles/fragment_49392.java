public static void topCenter(String fSlash, String bSlash) {
    divider();
    for(int fb = 0; fb <= 2; fb++) {
        System.out.print("|");
        for(int repeat = 0; repeat < 2; repeat++) {
            printDots(2 - fb);
            for(int i = 0; i <= fb; i++) {
                System.out.print(fSlash + bSlash);
            }
            printDots(2 - fb);
        }
        System.out.println("|");
    }
    for(int fb = 2; fb >= 0; fb--) {
        System.out.print("|");
        for(int repeat = 0; repeat < 2; repeat++) {
            printDots(2 - fb);
            for(int i = fb; i <= fb * 2; i++) {
                System.out.print(bSlash + fSlash);
            }
            printDots(2 - fb);
        }
        System.out.println("|");
    }
    //bottomCenter(fSlash, bSlash);
}

public static void printDots(final int count) {
    for(int i = 0; i < count; i++) {
        System.out.print(".");
    }
}
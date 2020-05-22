public static void main(String[] args) {
    printAsterisks(11, true);
    printAsterisks(13, true);
    for(int i = 6; i < 10; i++){
        printSpaced(i);
    }
    for(int i = 10; i > 5; i--){
        printSpaced(i);
    }
    printAsterisks(13, true);
    printAsterisks(11, true);
}

static void printSpaced(int spaces){
    printAsterisks(4, false);
    for(int i = 0; i < spaces; i++){
        System.out.print(" ");
    }
    printAsterisks(4, true);
}

static void printAsterisks(int n, boolean newLine){
    for(int i = 0; i < n; i++){
        System.out.print('*');
    }
    if(newLine){
        System.out.println("");
    }
}
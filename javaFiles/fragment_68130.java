int nextKeyboardInt(){
    while(!scanner.hasNextInt()){
        scanner.next();
    }
    return scanner.nextInt();
}
a[i][j] = nextKeyboardInt();
//another code//
int anotherInt = nextKeyboardInt();
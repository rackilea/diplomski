static String transformCharArr(char[] arr){
    if(arr.length > 1) return ""; // array should only contain 1 element
    int value = (int)arr[0]; // using int since char is the only unisgned 2-byte type in all of Java, short isn't enough given MAX(short) = 32,767 while max(char) = 65,535
    short xxx=100, y=1, z=1; // all shorts since they never exceed certain limits
    int product = 0; // to stop the loop, int because short*short*short gives int type, and product is comparable to value, so it has to support more than max(short)
    for(xxx=100; xxx<=999; xxx++){ // first loop xxx to minimize it
        for(y=1; y<=9; y++){ // loop y before z to favor maximizing z
            for(z=1; z<=9; z++){ // ensures maximizing z before y
                if((product = xxx*y*z)== value) 
                    break;
            }
            if(product == value) break;
        }
        if(product == value) break;
    }
    if(y==1) return String.format("%d-%d", xxx, z); // if y is 1, ignore it
    if(z==1) return String.format("%d-%d", xxx, y); // if z is 1 ignore it
    return String.format("%d-%d-%d", xxx,y,z);
}
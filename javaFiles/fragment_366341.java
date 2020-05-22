static long[] getValues(String[] args){
    long []a = new long [args.length];
    for (int i = 0; i < args.length; ++i) 
        a[i] = Long.parseLong (args[i]);
    return a;
}

void main(String[] args){
    long[] values = getValues(args); 
    //here you call the static function
    //do some code magic with those values
}
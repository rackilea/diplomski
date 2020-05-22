public static int min(int[] args){
    if (args == null || args.length < 1) {
        throw new IllegalArgumentException("... some error message...");
    }

    return min(args[0], Arrays.copyOfRange(args, 1, args.length));
}
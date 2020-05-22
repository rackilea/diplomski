for (int j = 1; j < args.length; j++) {
    if (!isInteger(args[j])) {
        System.out.println("Argument type mismatch");
        return; // Added this line
    }
}
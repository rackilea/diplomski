public static void main (String args[]) {
    for (int i = 0; i < args.length; i++) {
        try{
            Integer.parseInt(args[i]);
        catch(NumberFormatException e){
            //e.printStackTrace();
            System.out.format("Input %d is incorrect : %s%n", i, args[i]);
        }

    }
}
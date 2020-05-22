public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        //ask user to enter either hex or binary
        System.out.println("Please enter a hex (0x) or binary (0b) number: ");

        //read input as string
        String hexString = input.nextLine();
        String binString = input.nextLine();

        //if prefix (0x)
        if (hexString.startsWith("0x")) {
            hexString = hexString.replaceAll("0x", "");
            int hex = Integer.parseInt(hexString, 16);
            System.out.println("Converting from base-16 to base-10.\n" + hex);

            //if there are no digits or invalid digits after Ox
            //if ((hexString.substring(beginIndex))) {
            //  System.out.println("Error parsing base-16 number");
            //}
            //if prefix (0b)    
        } else if (binString.startsWith("0b")) {
            binString = binString.replaceAll("0x", "");
            int bin = Integer.parseInt(binString, 2);
            System.out.println("Converting from base-2 to base-10.\n" + bin);

            //if there are no digits or invalid digits after Ob
            //if ((binString.substring(beginIndex))) {
            //  System.out.println("Error parsing base-2 number");
            //}
        } else {
            System.out.println("I don't know how to covert that number");
        }
    }
public static String getFlavour() {
    BufferedReader keyboardInput = null;
    try {
        keyboardInput = new BufferedReader(new InputStreamReader(System.in));
        System.out.println(" please enter your flavour ice cream");
        // in this case, you don't need to declare this extra variable
        // String flavour = keyboardInput.readLine();
        // return flavour;
        return keyboardInput.readLine();
    } catch (IOException e) {
        // handle this
        e.printStackTrace();
    }
    return null;
}
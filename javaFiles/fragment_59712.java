try {
    String action = (String) Intent.class.getDeclaredField(userInput).get(String.class);
    // use the action value here..
} catch (Exception e) {
    // no such action possible, maybe mistyped the action name
    e.printStackTrace();
}
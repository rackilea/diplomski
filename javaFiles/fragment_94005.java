public static void main(String ... args) {
    // Register the strategies
    CheckStrategy strat1 = new AllTheSameCheck();
    CheckStrategy strat2 = new ConcreteExpectedResultPerUnitCheck();
    CheckStrategy strat3 = new MinimumThresholdDecoratorCheck(); 

    PostValidation.INSTANCE.registerNewStrategy(strat1.getName(), strat1);
    PostValidation.INSTANCE.registerNewStrategy(strat2.getName(), strat2);
    PostValidation.INSTANCE.registerNewStrategy(strat3.getName(), strat3);
    ...
    // Parse the arguments
    Properties prop = new Properties();
    for (String arg : args) {
        String[] kv = arg.split("=");
        if (kv.length == 2) {
            prop.setProperty(kv[0], kv[1]);
        }
    }
    // Pass the passed arguments to the application
    App app = new App(prop);
    ...
}
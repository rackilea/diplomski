public class ByteBuddyTest {

    public static void main(String[] args) throws Exception {    

        ByteBuddyAgent.install();

        new ByteBuddy()
            .redefine(RemoteWebDriver.class)
            .visit(Advice.to(WebDriverAdvice.class).on(named("findElement").and(takesArguments(1))))
            .make()
            .load(ByteBuddyTest2.class.getClassLoader(),
                  ClassReloadingStrategy.fromInstalledAgent());

        new ByteBuddy()
            .redefine(RemoteWebElement.class)
            .visit(Advice.to(WebElementAdvice.class).on(named("click")))
            .make()
            .load(ByteBuddyTest2.class.getClassLoader(),
                  ClassReloadingStrategy.fromInstalledAgent());

        InternetExplorerDriver driver = new InternetExplorerDriver();

        driver.get("<some webpage>");

        driver.findElement(By.id("<some_id>")).click();
    }

    public static class WebDriverAdvice {    
        @Advice.OnMethodEnter
        public static void enter(@Advice.Origin String method) {
            System.out.printf("Driver Method Enter: %s\n", method);
            Times.start = System.currentTimeMillis();
        }
    }

    public static class WebElementAdvice {
        @Advice.OnMethodExit
        public static void exit(@Advice.Origin String method, @Advice.This Object target) {
            System.out.printf("Element Method Exit: %s\n", method);
            System.out.println("Time: " + (System.currentTimeMillis() - Times.start));
        }
    }

    public static class Times {
        public static long start = 0L;
    }
}
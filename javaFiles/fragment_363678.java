class MyRunner extends Runner {
    @Override
    Description getDescription() {
        return null
    }

    @Override
    void run(RunNotifier notifier) {
        // LoginTests.class is a test class I want to run
        LoginTests loginTests = new LoginTests(<my args here>)

        Description description = Description.createSuiteDescription(LoginTests)
        notifier.fireTestStarted(description)
        try {
            log.info("About to doSomething()...")
            loginTests.doSomething()
            log.info("Did it...")
            notifier.fireTestFinished(description)
        } catch(Throwable throwable) {
            log.info("doSomething() failed...")
            notifier.fireTestAssumptionFailed(new Failure(description, throwable))
        }
    }
}

Result testResults = new JUnitCore().run(Request.runner(new MyRunner()))
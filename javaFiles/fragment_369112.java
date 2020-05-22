protected Matcher<File> producesCompilationErrorWith(final File aspectFile) {
    return new AspectJCompilationMatcher(aspectFile, Result.ERROR);
}

private class AspectJCompilationMatcher extends TypeSafeMatcher<File> {
    private final File aspectFile;
    private final Result expectedResult;
    private Result result;

    public AspectJCompilationMatcher(final File aspectFile, final Result expectedResult) {
        this.aspectFile = aspectFile;
        this.expectedResult = expectedResult;
    }

    @Override
    protected boolean matchesSafely(final File javaSourceFile) {
        result = compile(javaSourceFile, aspectFile);
        return result == expectedResult;
    }

    @Override
    public void describeTo(final Description description) {
        description.appendText("compilation result: ").appendValue(result);
    }
}

enum Result {
    ERROR,
    WARNING,
    SUCCESS
}

private Result compile(final File javaFileName, final File aspectFile) {

    assertExists(javaFileName);
    assertExists(aspectFile);

    List<String> argList = newArrayList();

    // java 7 compatibility
    argList.add("-source");
    argList.add("1.7");
    argList.add("-target");
    argList.add("1.7");

    // set class path
    argList.add("-cp");
    argList.add(System.getProperty("java.class.path"));

    // add java file
    argList.add(javaFileName.getAbsolutePath());

    // add aspect files
    argList.add(aspectFile.getAbsolutePath());
    for (File additionalAspectFile : requiredAspects) {
        assertExists(additionalAspectFile);
        argList.add(additionalAspectFile.getAbsolutePath());
    }

    String[] args = argList.toArray(new String[argList.size()]);
    List<String> fails = newArrayList();
    List<String> errors = newArrayList();
    List<String> warnings = newArrayList();
    List<String> infos = newArrayList();

    // org.aspectj.tools.ajc.Main;
    Main.bareMain(args, false, fails, errors, warnings, infos);
    if (!fails.isEmpty() || !errors.isEmpty()) {
        return Result.ERROR;
    } else if (!warnings.isEmpty()) {
        return Result.WARNING;
    } else {
        return Result.SUCCESS;
    }
}
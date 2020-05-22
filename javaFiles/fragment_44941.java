try {
    new GroovyShell().parse(groovyCode);
} catch(MultipleCompilationErrorsException cfe) {
    ErrorCollector errorCollector = cfe.getErrorCollector();
    System.out.println("Errors: "+errorCollector.getErrorCount());
}
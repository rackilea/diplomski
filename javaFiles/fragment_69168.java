/**
 * Evaluates some script against the current Binding and returns the result
 *
 * @param codeSource
 * @throws CompilationFailedException
 */
public Object evaluate(GroovyCodeSource codeSource) throws CompilationFailedException {
    Script script = parse(codeSource);
    return script.run();
}
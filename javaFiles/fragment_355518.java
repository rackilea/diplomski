private void executeScript() {
    String source = "" +
            "game.walk();\n" +
            "game.walk();\n" +
            "var jumps = 10;\n" +
            "for (var i = 0; i < jumps; i++) {\n" +
            "   game.jump(i + 1);\n" +
            "}";


    org.mozilla.javascript.Context cx = org.mozilla.javascript.Context.enter();
    cx.setOptimizationLevel(-1); // disable compilation
    Scriptable scope = cx.initStandardObjects();
    Object wrappedOut = cx.javaToJS(this, scope);
    ScriptableObject.putProperty(scope, "game", wrappedOut);
    Object result = cx.evaluateString(scope, source, "<cmd>", 1, null);

}

public void walk() {
    System.out.println("Walking!");
}

public void jump(int count) {
    System.out.println("Jumping! " + count);
}
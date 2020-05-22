private static Class c;

static {
    try {
        c = Class.forName("net.codegentest.CodeGenTest");
    } catch (ClassNotFoundException _x) {
    }
}
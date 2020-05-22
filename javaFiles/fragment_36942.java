jshell> String a = ((Supplier<String>)(() -> StackWalker.getInstance(StackWalker.Option.RETAIN_CLASS_REFERENCE).getCallerClass().getName())).get();
a ==> ""

jshell> System.out.println(a);
REPL.$JShell$11

jshell> "$JShell$foobar"
$3 ==> ""
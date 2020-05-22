class MyDSL {
     public void foo(int x, int y, Closure z) { ... }
     public void setBar(String a) { ... }
 }

 CompilerConfiguration cc = new CompilerConfiguration();
 cc.setScriptBaseClass(DelegatingScript.class);
 GroovyShell sh = new GroovyShell(cl,new Binding(),cc);
 DelegatingScript script = (DelegatingScript)sh.parse(new File("my.dsl"))
 script.setDelegate(new MyDSL());
 script.run();
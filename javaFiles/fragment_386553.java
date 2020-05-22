System.setProperty("org.jruby.embed.localvariable.behavior", "persistent"); 

// .. snip

Object o = se.eval(sb.toString());

se.eval("o.a = 'A'");
se.eval("o.b = 'B'");

System.out.println( ((Invocable) se).invokeMethod(o, "str"));
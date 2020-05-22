ubuntu@ubuntu:/tmp$ jrubyc --javac myscript.rb
ubuntu@ubuntu:/tmp$ javap MyScript
Compiled from "MyScript.java"
public class MyScript extends org.jruby.RubyObject {
  public static org.jruby.runtime.builtin.IRubyObject __allocate__(org.jruby.Ruby, org.jruby.RubyClass);
  public MyScript();
  public java.lang.Object run();
  static {};
}
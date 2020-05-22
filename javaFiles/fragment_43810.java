[[syntax trees at end of uncurry]] 
package testing {
  object ParamTest extends Object {
    def <init>(): testing.ParamTest.type = {
      ParamTest.super.<init>();
      ()
    };
    def bar(x: Int, y: () => Int): Int = if (x.>(0))
      y.apply()
    else
      10;
    def baz(x: Int, f: () => Int): Int = if (x.>(0))
      f.apply()
    else
      20
  }
}
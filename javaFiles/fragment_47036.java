class iw$WithinModule extends Object {
    private[this] val string: String = _;
    <stable> <accessor> def string(): String = iw$WithinModule.this.string;
    def <init>(): $line184.iw$WithinModule = {
      iw$WithinModule.super.<init>();
      iw$WithinModule.this.string = "this is the local scala string";
      ()
    }
  }
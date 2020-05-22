Handler handler = new Handler();
final InheritableThreadLocal<String> foo = new InheritableThreadLocal<String>();

final Runnable r = new Runnable() {
    public void run() {
         System.out.print(foo.get()); // prints "Bar"
    }
};

foo.set("Bar");
handler.postDelayed(r, 1);
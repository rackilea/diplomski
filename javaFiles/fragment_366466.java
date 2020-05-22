public class RunTv {
    public static void openNewTv()
    {
       Remote r = new Remote("+");
       Tv t = new Tv("+");
       t.open();
    }
}
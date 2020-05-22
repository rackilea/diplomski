public class RunTv {
    public void openNewTv()
    {
       Remote r = new Remote("+");
       Tv t = new Tv("+");
       t.open();
    }
}
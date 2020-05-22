public class TickObject() {
    private Ticker ticker;

    public TickObject(Ticker ticker) {
         this.ticker = ticker;
    }

    public void doTick() {
        ticker.doTick();
    }
}
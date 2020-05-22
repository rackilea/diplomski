@Override
public void onEnable() {
    try {
        this.getLogger().log(Level.INFO, "Loading up!");
        IRCBotMain.main(null);
    } catch (Exception ex) {
        // respond to this exception by logging it or wrapping it in another exception and re-throwing etc
    }
}
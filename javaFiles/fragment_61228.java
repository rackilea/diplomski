if (itemId == 608) {
  c.sendMessage("The scroll has brought you to the Revenants.");
  c.sendMessage("They are very ghastly, powerful, undead creatures.");
  c.sendMessage("If you defeat them, you may receive astounding treasures.");
  c.sendMessage("If you donate you may visit the Revenants anytime without a scroll.");
  c.getPA().movePlayer(3668, 3497, 0);
  c.gfx0(398);
  c.getItems().deleteItem(608, 1);

  /* only if the parameter Client c isn't declared final */
  final Client client = c;
  /* set these to the location you'd like to teleport to */
  final int x = ...;
  final int y = ...;

  EventManager.getSingleton().addEvent(new Event() {

    public void execute(final EventContainer container) {
      client.getPA().movePlayer(x, y, 0);
    }
  }, 1800000); /* 30 min * 60 s/min * 1000 ms/s = 1800000 ms */
}
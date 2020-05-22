public class Foo {
  private class Bar {
    public void barMethod() {
      int[] counter = new int[] { 0 };
      Bar instance = this;
      BukkitTask barTask = new BukkitRunnable() {
        @Override
        public void run() {
          if (counter[0] == 5) {
            this.cancel();
            return;
          }
          instance.doStuff(); // don't worry it exists
          counter[0]++;
        }
      }.runTaskTimer(this.plugin, 0L, 2L);
    }
  }
}
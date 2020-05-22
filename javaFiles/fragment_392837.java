public Input(World world) {
  button.addListener(new ClickListener() {
    @Override
    public void clicked(InputEvent event, float x, float y) {
      // error: world is not final
      System.out.println(world.data.importantNumber);
    }
  }
}
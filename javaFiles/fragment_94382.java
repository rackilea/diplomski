@Provides
Bar provideBar(Sly sly) {
  Bar bar = new Bar();
  bar.sly = sly;
  return bar;
}
public static final Function<Pojo, Colour> COLOUR =
    new Function<Pojo, Colour>() {
      @Override public Colour apply(Pojo input) {
        return input.getColour();
      }
    };
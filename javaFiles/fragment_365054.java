public enum Mode {

  ON { Color color() {return Color.GREEN;}},
  OFF { Color color() {return Color.RED;}},
  STANDBY { Color color() {return Color.YELLOW;}},
  DEFAULT { Color color() {return Color.BLACK;}};

  abstract Color color();

}//enum Mode
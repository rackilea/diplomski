public enum Flag {
    APPLICATION_LOADED(false), NEED_SAVING(true), CAN_EXIT(false) /*, ... */;

    private boolean state;
    private Flag(boolean initialState) {
      this.state = initialState;
    }

    public boolean getState() {return state;}
    public void setState(boolean state) {this.state = state;}
}
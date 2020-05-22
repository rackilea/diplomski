public void setState(State state) {
    State oldState = null;
    synchronized (this) {
      if (this.state != state) {
        oldState = this.state;
        this.state = state;
      }
    }

    if (oldState != null)
      support.firePropertyChange("state", oldState, state);
  }
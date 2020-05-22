Class YourButton extends Button { 
  int focusCount; 
  int setNameCount
  int getFocusCount() {return this.focusCount;}
  void setFocusCount(int counter) {this.focusCount = counter} // optional to reset counter
  void incrementFocusCount() {this.focusCount = getFocusCount() + 1;)
  ...
  void countingFocus() {
    incrementFocusCount();
    focus()
  }
  ...
}
enum InputState {
   NAME("Name"), ADDRESS("Address"), CITY("City"), DONE("Done");

   private String text;

   private InputState(String text) {
      this.text = text;
   }
   public String getText() {
      return text;
   }
}
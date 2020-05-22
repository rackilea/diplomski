class GetDataAction extends AbstractAction {

   private GetInputPanel inputPanel;
   private Data data;
   private InputState state = InputState.NAME;

   public GetDataAction(GetInputPanel inputPanel, Data data) {
      super("Get Name");
      this.inputPanel = inputPanel;
      this.data = data;
   }

   @Override
   public void actionPerformed(ActionEvent evt) {
      if (state == InputState.NAME) {
         data.setName(inputPanel.getInputText());
         state = InputState.ADDRESS;
      } else if (state == InputState.ADDRESS) {
         data.setAddress(inputPanel.getInputText());
         state = InputState.CITY;
      } else if (state == InputState.CITY) {
         data.setCity(inputPanel.getInputText());
         state = InputState.DONE;
         System.out.println("Data: " + data);
         putValue(NAME, "");
         inputPanel.setPrompt("");

         inputPanel.setEnabled(false);
      } 

      if (state != InputState.DONE) {
         putValue(NAME, "Get " + state.getText());
         inputPanel.setPrompt("Please Enter Your " + state.getText());
      }
      inputPanel.clearInputText();
   }
}
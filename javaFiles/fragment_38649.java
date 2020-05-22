@Override
public void actionPerformed(ActionEvent e) {
    CardButton justClickedButton = e.getSource();
    justClickedButton.setFaceUp();
    CardButton previouslyClickedButton = Game.lastClicked;
    if(previouslyClickedButton == null){
        JOptionPane.showInputDialog("id "+justClickedButton.getCard().getValue());
        previouslyClickedButton = justClickedButton;
    }
    else{
         currentState = model.compareCards(justClickedButton, previouslyClickedButton);

         if(currentState == State.Match){
             justClickedButton.setVisible(false);
             previouslyClickedButton.setVisible(false);               
         }

         if(currentState == State.Close){
             justClickedButton.setFaceDown();
             previouslyClickedButton.setFaceDown();               
         }

         if(currentState == State.Continue){
         }

         previouslyClickedButton = null;
     }
}
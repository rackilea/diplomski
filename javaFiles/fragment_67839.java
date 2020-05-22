JButton nextBtn;
 int currentIndex;

 ...

 currentIndex = 0;
 //display the first item in the array.
 boatMaterialTextField.setText(array[currentIndex].getBoatMaterial());
 boatPropulsionField.setText(array[currentIndex].getBoatPropulstion());

 nextBtn = new JButton("Next>>");
 nextBtn.addActionListener(new ActionListener(){
    public void actionPerformed(ActionEvent e){
       if(currentIndex < array.length){
        boatMaterialTextField.setText(array[++currentIndex].getBoatMaterial());
        boatPropulsionField.setText(array[currentIndex].getBoatPropulstion());     
       }
    }
 });
int flag=0;  //initial value for your flag

 for(int i=0; i<size.length; i++){
        if(userInput == size[i]){
            JOptionPane.showMessageDialog(null, userInput+" = "+total[i]);
            flag=1; //states that user entered correct value
        }
    }

  //check here if user input was correct or not
  if(flag==0){
    //display the error message here
  }
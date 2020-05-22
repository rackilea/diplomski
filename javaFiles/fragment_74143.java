public void recordResult()
 {
  int inputResult; 
  String inputString = null;

  for(Person : aList)
  {  
     if (inputString == null) {
        inputString = Dialog.request("Please Enter A Result");
     } else {
        inputString = Dialog.request("Please Enter Another Result");
     } 
     inputResult = Integer.parseInt(inputString);
     s.setResult(inputResult);
  }

}
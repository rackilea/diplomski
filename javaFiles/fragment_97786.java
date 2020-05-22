strArray = num.replaceAll("\\[", "").replaceAll("\\]", "").split(",");

if (strArray != null){
   //You have to initialize your variable
   intArray = new int[strArray.length];

   for (int i = 0; i < strArray.length; i++) {
     try {
        intArray[i] = Integer.parseInt(strArray[i]);
     } catch (NumberFormatException nfe) {
          nfe.printStackTrace();
     }; 
   }
}
public static int[] getCalculate(double[]decayRate, int[]desiredYield, String[]treeTypes){
  int totalSeeds =0;
  int totalTrees=0;
  int minSeeds=0;      
  int index=0;
  int[] finalResult = new int[3];  //Updated code...
  for(int i=0; i<treeTypes.length;i++){
      minSeeds+=(desiredYield[index] * (decayRate[index]*7))+desiredYield[index];
      totalSeeds+=minSeeds;
      totalTrees+=desiredYield[index];

      }
     finalResult[0] = minSeeds; //Updated code...
     finalResult[1] = totalSeeds; //Updated code...
     finalResult[2] = totalTrees; //Updated code...
   return finalResult; //Updated code...
}

   public static void printMessage(double[]decayRate, int[]desiredYield, String[]treeTypes){
   finalResult = getCalculate(decayRate, desiredYield, treeTypes); //Updated code...

   String treeReport = "Tree Type | Minimum Seeds | Total Seeds | Total Trees ";
   for(int i=0; i<treeTypes.length; i++){
    treeReport += "\n"+treeTypes[i] + " " + finalResult[0] + " " + finalResult[1] + " " + finalResult[2]; //Updated code...
   }
   JOptionPane.showMessageDialog(null, treeReport);
  }
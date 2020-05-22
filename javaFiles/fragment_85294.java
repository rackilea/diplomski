public static int lookupReferenceInTable (String instanceMode, String instanceTID){
        int ModeMatches[]=getReferencesToMode(Integer.parseInt(instanceMode));
        int lineLookup = getReferenceFromPossibleMatches(ModeMatches, instanceTID);
        return lineLookup;
    }



        private static int getReferenceFromPossibleMatches(int[] ModeMatches, String instanceTID) {
      int counter = 0;
      int match = 0;
      instanceTID=instanceTID.trim();
      while ( counter < ModeMatches.length ){
         int x = ModeMatches[counter];
         if (Data[x][DataTestID].equals(instanceTID)){
         return ModeMatches[counter];
         }
         counter ++ ;
      }
      return match;

    }
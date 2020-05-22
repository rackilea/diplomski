result = new Delegate<PersonArt>() {
      PersonArt delegator(String pShortName, Integer pOld, Integer pSize)
      {
         return doEvaluatePersonArt(pShortName, pOld, pSize);
      }
   };
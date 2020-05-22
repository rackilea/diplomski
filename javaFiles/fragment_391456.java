public int incSum=0;

int[] numbersinc = new int[theAmount.length];
incSum = 0; //add this line
    for(int i=0;i<theAmount.length;i++)
    {

        numbersinc[i]=Integer.parseInt(theAmount[i]);

        incSum=incSum+numbersinc[i];
    }

    Log.e("SUM INC","Sum Inc= "+incSum);    <<<<<- This sum is multiplying
  numbersinc = null;
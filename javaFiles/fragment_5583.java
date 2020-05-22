public void fill(int[] arr) {
       int x = 0;
      // Log.e(TAG, "*********** startP = "+startP + "  endP = " + endP);
      for (int p = startP; p < endP; p++, x++)
         arr[p] = storedValues[p];

      Log.e(TAG, "*********** arr = " + arr[x]);
      }
  }
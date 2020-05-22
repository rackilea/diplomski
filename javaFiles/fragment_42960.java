int posCount=0;
    int negCount=0;
    for (int i = 0; i < integers.length; i++) {
      integers[i] = r.nextInt(21)-10;
      if (integers[i]>0) 
          posCount++;
      else if (integers[i]<0) 
          negCount--;
      if (posCount>6||negCount>6||integers[i]==0)
          i--; // redo the current iteration of the loop, since the last generated
               // number should be replaced
    }
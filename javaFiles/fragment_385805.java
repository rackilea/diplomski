int first = 0;
int second = 0;
int third = 0;

boolean[] codeUsed = new boolean[4];
boolean[] guessUsed = new boolean[4];

//same value and same place
for (int i = 0; i < 4; i++) 
    {
       if (A[i] == B[i]) 
       {
          first++;
          codeUsed[i] = guessUsed[i] = true;
       }
    }

//same value but not right place
for (int i = 0; i < 4; i++) 
   {
   for (int j = 0; j < 4; j++) 
      {
      if (!codeUsed[i] && !guessUsed[j] && A[i] == B[j])
         {
            second++;
            codeUsed[i] = guessUsed[j] = true;
            break;
         }
       }
    }

//not the same value
third = 4 - first - second;
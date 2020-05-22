public static void countArray()
{

  int vowelA=0, vowelE=0, vowelI=0, vowelO=0, vowelU=0, vowelY=0;
  int elsePlaceHolder = 0;
  char [] arr = new char[100];
  arr=createArray();
  for (int x = 0; x < 100; x++)
  {

     if (arr[x] == 'a')
     vowelA++;

     else if (arr[x] == 'e')
     vowelE++;

     else if (arr[x] == 'i')
     vowelI++;

     else if (arr[x] == 'o')
     vowelO++;

     else if (arr[x] == 'u')
     vowelU++;

     else if (arr[x] == 'y')
     vowelY++;

     else
     elsePlaceHolder++;

  }
  System.out.print(vowelA+" "+vowelE+" "+vowelI+" "+vowelO+" "+vowelU+" "+vowelY);
}
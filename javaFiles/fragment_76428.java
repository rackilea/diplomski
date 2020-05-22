public static int[] shuffle(int[] array, int[] top, int[] bottom)
      {
        for(int j = 0; j < top.length; j++)
        {
          array[j*2] = top[j];
          array[j*2+1] = bottom[j];
        }
        return array;
      }

    public static String print(int[] array)
  {
String result="";
    for(int j = 0; j < array.length; j++)
    {
      result=result+top[j];
    }
    return result;
  }
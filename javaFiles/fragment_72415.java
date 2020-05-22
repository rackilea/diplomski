static void permute(String... str)
{    
  char[][] chars = new char[str.length][];
  for(int i=0; i<str.length; i++)
    chars[i] = str[i].toCharArray();

  int[] idx = new int[str.length];

  char[] perm = new char[str.length];    
  for(int i=0; i<str.length; i++)
    perm[i] = chars[i][0];

  while(true)
  {      
    System.out.println(new String(perm));

    int k=str.length-1;
    for(; k>=0; k--)
    {
      idx[k] += 1;
      if(idx[k] < chars[k].length) 
      {
        perm[k] = chars[k][idx[k]];
        break;
      }
      idx[k] = 0;
      perm[k] = chars[k][idx[k]];
    }
    if(k < 0) break;
  }
}
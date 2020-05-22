Integer[] dizi = new Integer[6];

for (int j = 0; j < 6; j++)
{
  boolean isValid;
  do
  {
     dizi[j] = (int) ((Math.random() * 6) + 1);
     isValid = true;
     for (int k = 0; isValid && k < j; k++)
        if (dizi[k] == dizi[j])
           isValid = false;
  }
  while (!isValid);
  dizi_asil[i][j] = dizi[j];
}
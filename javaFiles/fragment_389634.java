while (i < a.size())
{
   while(a[i] + b[j] > X && j > 0) j--;
   if (a[i] + b[j] == X) writeAnswer(i, j);
   i++;
}
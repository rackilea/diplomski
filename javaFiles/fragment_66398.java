public static int[] indeks(int[] a)
{
 int []score=new int[3];
 int []index=new int[3];
 score[0]=0;score[1]=0;score[2]=0;
 //game b/w a[0] and a[1]
 if(a[0]>a[1])
  score[0]++;
 else score[1]++;
 //game b/w a[1] and a[2]
 if(a[1]>a[2])
  score[1]++;
 else score[2]++;
 //game b/w a[0] and a[2]
 if(a[0]>a[2])
  score[0]++;
 else score[2]++;
 //fill the index array
 index[score[0]%3]=0;
 index[score[1]%3]=1;
 index[score[2]%3]=2;     
}
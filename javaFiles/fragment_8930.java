private double getMax()
{
int max = -Integer.MAX_VALUE;
final int[] intData = new int[data.length];
for(int i = 0; i < data.length; i++){
   if(data[i] > max)
    max = data[i];
}
return max;
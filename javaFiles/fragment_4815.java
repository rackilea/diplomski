short[] target=new short[LENGTH OF 4 MINUTES];
int idx=0;
process(short[] audio, int l)
{
  for(int i=0;i<l;i++)
  target[idx++]+=audio[i]/2;
}
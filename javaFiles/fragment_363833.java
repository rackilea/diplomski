byte[] first = {1,2,4,56,6};
     byte[] second = {4,5,7,9,2};
     byte[] merged = new byte[first.length+second.length];

     System.arraycopy(first,0,merged,0,first.length);
     System.arraycopy(second,0,merged,first.length,second.length);
for(int i=0; i<merged.length;i++)
{
    System.out.println(merged[i]);
}
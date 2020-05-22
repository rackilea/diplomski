//to avoid accessing out of bound index
 int max = (indx+3) >= count ? count -1 : (indx+3);//maximum index should be T-1.
 indx = (indx - 3) < 0 ? 0 : (indx - 3); // minimum index should be 0.

for(;indx <= max;indx++)
{
  System.out.println(lst.get(indx));
}
String name;
int max;
int[] count;

public Histogram(String name, int max) 
{
   this.name = name;
   this.max = max;
   this.count = new int[max+1];  
}
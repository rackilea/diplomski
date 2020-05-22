public int countOccurrences(int element) 
{
     int count = 0;
     for(int i = this.data.length - 1; i >= 0; i--) 
        if(this.data[i] == element) 
          count ++;
    return count;
}
while(i<size-1) {
            if (elementData[i]<=elementData[i+1]){
                count++;
            }
            else {
                max_count=Math.max(max_count,count+1);
                count=0;
            }
            i++;
        }
// added following 1 line.
    max_count=Math.max(max_count,count+1);
        return max_count;
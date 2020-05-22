T tmp = a[low];
    for(int i=0;i<=high;i++){
        if(a[i].compareTo(tmp)>0){
            tmp = a[i];
            getLargest(a,i,high);               
        }
    }
    return tmp;
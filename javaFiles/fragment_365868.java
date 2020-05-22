public static void main(String[] args){
    int []a={22,45,1,4,89,7,0};
    mergeSort(a);
    System.out.println(Arrays.toString(a));

}

public static void mergeSort(int [] a){
    mergeSort(a,0,a.length-1);
}

public static void mergeSort(int []a, int beg,int end){
    if(beg<end){
        int mid=(beg+end)/2;
        mergeSort(a,beg,mid);
        mergeSort(a,mid+1,end);
        merge(a,beg,mid,end);
    }
}

private static void merge(int []a, int beg, int middle, int end){
    int [] d=new int[a.length];
    int mid=middle+1; //start of second half of array
    int beg1=beg;
    for(int i=beg1;i<=end;i++){
        if(beg<=middle && mid<=end){  
            if(a[beg]<=a[mid]) {
            d[i]=a[beg];
            beg++;
            } else if(a[mid]<=a[beg]){
                    d[i]=a[mid];
                    mid++;
            }
        }else if(beg>middle){         
            d[i]=a[mid];
            mid++;
        }else if(mid>=end){ //<= here
            d[i]=a[beg];
            beg++;
        }
    }
    for(int w=beg1;w<=end;w++){
        a[w]=d[w];
    }
}
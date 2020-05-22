public class MergeSort {

    private int[] helper;
    private int[] numbers;

    private int number;

    //sort method
    public MergeSort(int[] values){
        this.numbers = values;
        this.number = values.length;
        this.helper = new int[number];
        merge(0, number-1);
    }

    //mergeSort method
    public void merge(int low, int high){
        if(low<high){
            int mid =(low+high)/2;
            merge(low, mid);
            merge(mid+1, high);
            combine(low, mid, high);
        }
    }
    //merge method
    public void combine(int low, int mid, int high){
        //copy numbers into helper array;
        for(int ii=low;ii<=high;ii++){
            this.helper[ii]=this.numbers[ii];
        }
        int ii = low;
        int jj = mid+1;
        int kk = low;
        while((ii <= mid) && (jj<=high)){
            if(helper[ii] <= helper[jj]){
                this.numbers[kk] = this.helper[ii];
                ii++;
            }else{
                this.numbers[kk] = this.helper[jj];
                jj++;
            }
            kk++;
        }
        while(ii<=mid){
            this.numbers[kk]=this.helper[ii];
            kk++;
            ii++;
        }

    }
    /**
     * @param args
     */
    public static void main(String[] args) {
        int[] values = new int[]{2,6,1,9,12,64,32,23,12,90,87};
        // TODO Auto-generated method stub
        MergeSort ms = new MergeSort(values);
        System.out.println(Arrays.toString(ms.numbers));
    }

}
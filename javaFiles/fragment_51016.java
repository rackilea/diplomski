public class x{
        public static void main(String args[]){
            int[] a= {20,13,6,7,80,-10,90,100};
            int i,j,c,largest;
            for(i=a.length-1;i>=0;i--){
                largest=0;
                for(j=1;j<=i;j++){
                    if(a[j]>a[largest]){
                        largest=j;
                    }

                }
                swap(a,largest,i);
            }
            for(c=0;c<a.length;c++)
                System.out.println(a[c]);
        }
        public static void swap(int[] arr, int a, int b){
            int temp;
            if(a==b){
                return;
            }
            temp=arr[a];
            arr[a]=arr[b];
            arr[b]=temp;
        }
    }
public class unique_array {
    public static void getUnique(int[] arr){
        for(int i=0;i<arr.length;i++) ***// This is Outer Loop Run once will choose each element once for comparing  in arr[i]***
        {
            boolean flag = false;  ***// Here flag is Initializing every time to false for new Comparing loop below*** 
            for(int j=0;j<i;j++) ***// this is comparing loop for run for every selected arr[i] for each element is unique or not*** 
            {
                if(arr[i]==arr[j])
                {
                    flag=true; ***//when selected item from outer loop found in array it will break***
                    break;
                }
            }
            if(!flag) ***// if loop completed and flag remains false***
            {
             System.out.println("unique element are: "+arr[i]);      
            }
        }
    }
    public static void main(String[] args) {
        int[] arr = {1,2,4,1,4,1,5,8,10};
        unique_array.getUnique(arr);

    }

}
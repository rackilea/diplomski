public static void main(String args[]) {

        Arrays.sort(arr);
        for (int i=0,j=arr.length-1;i<arr.length && j>=0;) {
            if ((arr[i]+arr[j])<15) {
                /*System.out.println(arr[i]+"-"+arr[last-i]);
                break;*/
                i++;
            } else if ((arr[i]+arr[j])>15) {
                j--;
            } else {
                System.out.println(arr[i]+"-"+arr[j]);
                break;
            }
        }
    }
public class Solution {
    public static void main(String[] args) {
        int[] arr = {3,6,1,2,8};
        System.out.println(solve(arr).toString());
    }

    private static List<Integer> solve(int[] arr){
        int[][] data = new int[arr.length][2];
        int max_length = 0;
        // first location for previous element index (for backtracing to print list) and second for longest series length for the element
        for(int i=0;i<arr.length;++i){
            data[i][0] = -1; //none should point to anything at first
            data[i][1] = 1;
            for(int j=i-1;j>=0;--j){
                if(arr[i] > arr[j]){
                    if(data[i][1] <= data[j][1] + 1){ // <= instead of < because we are aiming for the first longest sequence
                        data[i][1] = data[j][1] + 1;
                        data[i][0] = j;
                    }
                }
            }

            max_length = Math.max(max_length,data[i][1]);
        }

        List<Integer> ans = new ArrayList<>();

        for(int i=0;i<arr.length;++i){
            if(data[i][1] == max_length){
                int curr = i;
                while(curr != -1){
                    ans.add(arr[curr]);               
                    curr = data[curr][0];
                }                
                break;
            }
        }

        Collections.reverse(ans);// since there were added in reverse order in the above while loop
        return ans;
    }    
}
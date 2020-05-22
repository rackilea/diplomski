static int[] input = {1,2,3,4,5,-6,7,8,9,10,200,-1000,100,250,-720,1080,200,300,400,500,50,74};

public static void main(String[] args) {    
    int[] two = new int[input.length/2];
    int[] one = new int[input.length - two.length];

    int totalSum = 0;
    for(int i=0;i<input.length;i++){
        totalSum += input[i];
        if(i<one.length)
            one[i] = input[i];
        else
            two[i-one.length] = input[i];
    }

    float goal = totalSum / 2f; 

    boolean swapped;
    do{
        swapped = false;
        for(int j=0;j<one.length;j++){
            int curSum = sum(one);
            float curBestDiff = Math.abs(goal - curSum);
            int curBestIndex = -1;

            for(int i=0;i<two.length;i++){
                int testSum = curSum - one[j] + two[i];
                float diff = Math.abs(goal - testSum);
                if(diff < curBestDiff){
                    curBestDiff = diff;
                    curBestIndex = i;
                }
            }

            if(curBestIndex >= 0){  
                swapped = true;
                System.out.println("swapping " + one[j] + " and " + two[curBestIndex]);
                int tmp = one[j];
                one[j] = two[curBestIndex];
                two[curBestIndex] = tmp;
            }
        }
    } while(swapped);

    System.out.println(Arrays.toString(one));
    System.out.println(Arrays.toString(two));
    System.out.println("diff = " + Math.abs(sum(one) - sum(two)));
}

static int sum(int[] list){
    int sum = 0;
    for(int i=0;i<list.length;i++)
        sum += list[i];
    return sum;
}
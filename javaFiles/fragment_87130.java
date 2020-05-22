public int[] evenOdd(int[] nums) {
int y=nums.length,x,a=0;
int temp=0;

for(x=0;x<y;x++)
{
    if(nums[x]%2==0) {
    if(a>(y-2))
       return nums;
    else{
    //nums[a]=nums[a]+nums[x];
    //nums[x]=nums[a]-nums[x];
    //nums[a]=nums[a]-nums[x];

    temp=nums[a];
    nums[a]=nums[x];
    nums[x]=temp;
    a+=1; 
        }

    } 

    return nums; 

    }
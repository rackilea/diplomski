int a = 4;
checkValue(a++);
void method(int value){
    System.out.println(a);
}

public boolean groupSum6(int start, int[] nums, int target) {

    if (start == nums.length) {return (target == 0);} //why did you compare some arbitrary number from array with length of this array? 

    if (nums[start] == 6){
        return groupSum6(start+1, nums, target - nums[start]);
    }

    if (groupSum6(start+1, nums, target - nums[start])) {return true;} //when you use start++ , you are calling the method with the same argument (i.e. start) recursively
    //if a particular number is choosen 

    if (groupSum6(start+1, nums, target)) {return true;}
    //if that particular  number is not chosen

    return false;
}
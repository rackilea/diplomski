Integer[] array = {0,1,2,3,4,5,6,7,8,9};
Integer sum = 0;
// Each element of the array will be unboxed exactly once
// sum will be unboxed 10 times
// result of the sum will be boxed 10 times
for(int i : array) sum += i;
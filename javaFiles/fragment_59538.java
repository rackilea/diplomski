double Average(params double[] nums) {
  var sum = 0.0;
  foreach(var num in nums) 
    sum += num;
  return sum / nums.Length;
}
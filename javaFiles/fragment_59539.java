double average(double... nums) {
  double sum = 0.0;
  for(double num : nums) 
    sum += num;
  return sum / nums.length;
}
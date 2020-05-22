if (nums1[nums1First] < nums2[nums2First])
{
  nums[i] = nums1[nums1First];
  if (nums1First == nums1.length - 1)
  {
    nums1[nums1First] = Integer.MAX_VALUE;
  }
  else
  {
    nums1First++;
  }
}
else
{
  nums[i] = nums2[nums2First];
  if (nums2First == nums2.length - 1)
  {
    nums2[nums2First] = Integer.MAX_VALUE;
  }
  else
  {
    nums2First++;
  }
}
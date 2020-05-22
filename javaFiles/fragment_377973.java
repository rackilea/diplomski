void DoSort (array, i, j)
{
  pivot = Partition (array, i, j)
  DoSort (array, 0, pivot)     // <<<<<< notice the '0' instead of 'i'
  DoSort (array, pivot + 1, j)
}
void DoSort (array, i, j)
{
  pivot = Partition (array, i, j)
  DoSort (array, i,pivot)
  DoSort (array, pivot + 1, j)
}
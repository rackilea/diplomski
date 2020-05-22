for i in 0..array.length-1
{
  min=MAX_INT
  minIndex=0
  for j in i+1..array.length-1
  {
    diff=abs(a[j]-a[i])
    if diff < min
    {
      min = diff
      minIndex=j
    }
  }
  swap a[i+1] with a[minIndex]
}
N = number of elements.
F[] = frequency array
so if N is odd
  find the element at floor(N/2)-th place and median is that element.
else
  find the element at floor((N-1)/2) and floor(N/2) th position and return their average.

Finding the element is simple:
Find( F[], p) // find the element at position p
{
  p=p+1
  for i in [0..|F|]
    cumulative+=F[i]
    if cumulative == p
      return this element.
    else cumulative >p
      return this element  
}
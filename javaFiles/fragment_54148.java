IntStream primes = from(2).filter(i -> p.test(i)).peek(i -> p = p.and(v -> v % i != 0));

IntPredicate p = x -> true;

IntStream from(int n)
{
  return IntStream.iterate(n, m -> m + 1);
}
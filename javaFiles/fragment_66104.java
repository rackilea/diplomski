final List<Integer> ili = ImmutableList.copyOf(Ints.asList(ints));
final Iterator<Integer> iit = ili.iterator();
for (int i = 0; iit.hasNext(); i++)
{
    System.out.format("index %d = %d", i, iit.next());
}
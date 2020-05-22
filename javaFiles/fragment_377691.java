public class Example
{
    public static void main(String... args) {
        Permutor p = new Permutor("abcdefghijklmnopqrstuvwxyz");

        System.out.println(p.size());

        int i = 0;

        for (String s : p) {
          System.out.println(i++ + ": " + s);
        }
    }


    public static int factorial(int n) {
        int fact = 1;
        for (int i = 1; i <= n; i++) {
            fact *= i;
        }
        return fact;
    }

    public static class Permutor extends AbstractCollection<String>
    {
        private String characters;

        public Permutor(String s)
        {
            characters = s;
        }

        @Override
        public Iterator<String> iterator()
        {
            if (characters.length() == 1) {
                return Collections.singleton(characters).iterator();
            } else {
                return new PermutingIterator(characters);
            }
        }

        @Override
        public int size()
        {
            return factorial(characters.length());
        }
    }

    private static class PermutingIterator implements Iterator<String>
    {
        private final char last;
        private final Iterator<String> inner;

        private String current;
        private int position;

        PermutingIterator(String s)
        {
            int lastIndex = s.length() - 1;
            this.inner = new Permutor(s.substring(0, lastIndex)).iterator();
            this.last = s.charAt(lastIndex);
        }

        @Override
        public boolean hasNext()
        {
            return inner.hasNext() || (current != null && position <= current.length());
        }

        @Override
        public String next()
        {
          while(true) {
              if (current != null && position <= current.length()) {
                  return new StringBuffer(current).insert(position++, last).toString();
              } else if (inner.hasNext()) {
                  position = 0;
                  current = inner.next();
              } else {
                  throw new IllegalStateException("no more permutations available");
              }
          }
        }

        @Override
        public void remove()
        {
          throw new UnsupportedOperationException();
        }
    }
}
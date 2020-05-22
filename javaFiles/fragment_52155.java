// Make an Iterable<Character> from a CharSequence.
public static class CharWalker implements Iterable<Character> {

    final CharSequence s;

    public CharWalker(CharSequence s) {
        this.s = s;
    }

    @Override
    public Iterator<Character> iterator() {
        return new Iterator<Character>() {
            int i = 0;

            @Override
            public boolean hasNext() {
                return i < s.length();
            }

            @Override
            public Character next() {
                return s.charAt(i++);
            }

        };
    }

}
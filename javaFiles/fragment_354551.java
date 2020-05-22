public class Test {
  public static void main(String args[]) {
    new Test().test();
  }

  public static class EnumIterator implements Iterator<Enum[]> {
    // The enums
    private final Enum[][] enums;
    // Where we are in each column.
    private final int[] is;
    // Which column to increment next.
    private int i = 0;

    // Construct from Enum[]s.
    public EnumIterator(Enum[]... enums) {
      // Grab the enums.
      this.enums = enums;
      // Start all ordinals at zero.
      is = new int[enums.length];
      // Next one to increment is the last one.
      i = enums.length - 1;
    }

    // Construct from classes.
    public EnumIterator(Class<? extends Enum>... classes) {
      this(enumsFromClasses(classes));
    }

    // Factory to build the Enum[] array from an array of classes.
    private static Enum[][] enumsFromClasses(Class<? extends Enum>[] classes) {
      Enum[][] theEnums = new Enum[classes.length][];
      for ( int j = 0; j < classes.length; j++ ) {
        theEnums[j] = classes[j].getEnumConstants();
      }
      return theEnums;
    }

    @Override
    public boolean hasNext() {
      // We stop when we are about to increment col 0 and we are at its end.
      return (i > 0 || is[0] < enums[0].length);
    }

    @Override
    public Enum[] next() {
      if (hasNext()) {
        // One from each.
        Enum[] next = new Enum[enums.length];
        for (int j = 0; j < next.length; j++) {
          next[j] = enums[j][is[j]];
        }
        // Step - Kinda like incrementing a number with each digit in a different base.
        // Walk back past '9's setting them to 0.
        for (i = is.length - 1; i > 0 && is[i] == enums[i].length - 1; i--) {
          // Back one.
          is[i] = 0;
        }
        // Step that one up one.
        is[i] += 1;
        return next;
      } else {
        throw new NoSuchElementException();
      }
    }

    @Override
    public void remove() {
      throw new UnsupportedOperationException("Not supported.");
    }
  }

  enum ABC {
    A, B, C;
  }

  enum XY {
    X, Y;
  }

  enum IJ {
    I, J;
  }

  private void test() {
    // Also works - but constructing from classes is cleaner.
    //Iterator<Enum[]> i = new EnumIterator(ABC.values(), XY.values(), IJ.values());
    Iterator<Enum[]> i = new EnumIterator(ABC.class, XY.class, IJ.class);
    for (Enum[] e : Iterables.in(i)) {
      System.out.println(Arrays.toString(e));
    }
  }
}
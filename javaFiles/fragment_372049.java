public class SomeClass {
  public static final Class<?> INT_ATOM_CLASS;
  static {
    Class<?> [] innerClasses = Atom.class.getDeclaredClasses();
    Class<?> intAtomClass = null;
    for (Class<?> klass : innerClasses) {
      if (klass.getSimpleName().equals("IntAtom")) {
        intAtomClass = klass;
        break;
      }
    }
    INT_ATOM_CLASS = intAtomClass;
  }
}
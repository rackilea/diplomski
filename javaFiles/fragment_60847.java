public class DiffExp implements LetLangExp {
  LetLangExp left, right;

  public DiffExp(LetLangExp l, LetLangExp r) {
    left = l;
    right = r;
  }

  public double eval() {
    return left.eval() - right.eval();
  }
}
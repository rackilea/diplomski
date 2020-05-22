@Override
public ExpFoo applyReplacement(Replacement s) {
    return new TimesExpFoo(
        this.left.applyReplacement(s),
        this.right.applyReplacement(s)
    );
}
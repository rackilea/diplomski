@Override
public ExpFoo applyReplacement(Replacement s) {
    ExpFoo exp = s.get(this);
    exp = exp.applyReplacement(s); // replace any contained variables as well
    return exp;
}
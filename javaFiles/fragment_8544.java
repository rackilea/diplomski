abstract class Magnitude {
public abstract boolean lessThan(Magnitude m);

public boolean lessThanEqualTo(Magnitude m) {
     return this.lessThan(m) || this.equalTo(m);
}
public boolean equalTo(Magnitude m) {
     return ((!this.lessThan(m))&&(!m.lessThan(this)));
}
public boolean greaterThan(Magnitude m) {
    return m.lessThen(this);
}
public boolean notEqual(Magnitude m) {
    return !this.equal(m);
}
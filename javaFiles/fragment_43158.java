@Override
public boolean equals(Object o) {
    boolean eq = super.equals(o);
    if (eq && o instanceof EntityA) {
        EntityA e = (EntityA) o;
        return Objects.equals(this.propOne, e.propOne) 
            && Objects.equals(this.propTwo, e.propTwo)
            && // compare other properties
    } else 
       return eq;
}
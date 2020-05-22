if (lhs.getClass() != rhs.getClass() {
    if (lhs instanceof String) {
        rhs = String.valueOf(rhs);
    }
    ...
}
return new TypeCasted(lhs, rhs);
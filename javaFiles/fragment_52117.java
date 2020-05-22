if (a || b || c) {
    if (a && b && c) return true;
    if (a) return !(b && c);
    if (b) return !c;
    return c;
}
return false;
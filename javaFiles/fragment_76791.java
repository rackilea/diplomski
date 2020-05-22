public Ternary getByValue(Boolean o) {
    if(o == null)
        return UNKNOWN;
    if(o)
        return TRUE;
    return FALSE;
}
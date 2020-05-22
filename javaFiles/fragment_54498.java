public boolean isExceptionObject(Object target) {
    if (target != null          
        && ((Optional) target).get().getId() == 1)
        return true;
    return false;
}
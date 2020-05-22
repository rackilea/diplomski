try {
    Enum.valueOf( (Class) enumClass, value );
    return true;
} catch(IllegalArgumentException e) {
    return false;
}
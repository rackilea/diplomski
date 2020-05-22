if (array == foo.array) {
    return true;
}

if (array == null || foo.array == null) {
    return false;
}

int length = array.length;

if (foo.length != length)
        return false;

    for (int i=0; i<length; i++) {
        String string1 = array[i];
        String string2 = foo.array[i];
        if (!(string1==null ? string2==null : string1.equalsIgnoreCase(string2)))
            return false;
    }
return true;
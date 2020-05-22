public boolean equals(Object anObject) {
    if (this == anObject) {
        return true;
    }

    if (anObject instanceof String) {
        String aString = (String)anObject;
        if (coder() == aString.coder()) {
          return isLatin1() ? StringLatin1.equals(value, aString.value)
            : StringUTF16.equals(value, aString.value);
        }
    }

    return false;
}
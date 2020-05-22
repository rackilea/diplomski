@Override
public boolean equals(Object obj) {
    if (obj instanceof Menu)
        return id == ((Menu)obj).getId();
    return false;
 }
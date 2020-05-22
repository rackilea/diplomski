@Override
public boolean equals(Object obj) {
    if(obj == this)
        return true;
    try {
        Subscriber s = (Subscriber)obj;
        return name.equals(s.getName());
    } catch (Exception e) {
        return false;
    }
}
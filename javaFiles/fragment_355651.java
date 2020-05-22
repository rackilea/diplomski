@Override
public Object assemble(Serializable cached, Object owner) {
    if(cached == null) {
        return null;
    }
    if(cached.equals("true")) {
        return true;
    }
    return false;
}
@Override
public boolean equals(Object obj) {

    if (obj == this){
       return true;
    }

    if (!(obj instanceof MyObject))
        return false;

    MyObject other = (MyObject)obj;

    return Objects.equals(m_ObjA, other.m_ObjA)
           && Objects.equals(m_ObjB, other.m_ObjB)
           && (myPrimitive == other.myPrimitive);
}
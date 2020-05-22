@Override
public final boolean isValueNode()
{
    switch (getNodeType()) {
        case ARRAY: case OBJECT: case MISSING:
            return false;
        default:
            return true;
    }
}
Object parameterArray = new Object[1];

public boolean setString(int paramIndex, String param) {
    if(paramIndex < 0 || paramIndex > parameterArray.length)
        throw new IllegalArgumentException("Can't set parameter " + paramIndex + ", The query only has " + parameterArray.length + " parameters."); 
    parameterArray[paramIndex - 1] = param;
}
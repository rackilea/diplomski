public Object add(Object op1, Object op2){

    if( op1 instanceof String || op2 instanceof String){
        return String.valueOf(op1) + String.valueOf(op2);
    }

    if( !(op1 instanceof Number) || !(op2 instanceof Number) ){
        throw new Exception(“invalid operands for mathematical operator [+]”);
    }

    if(op1 instanceof Double || op2 instanceof Double){
        return ((Number)op1).doubleValue() + ((Number)op2).doubleValue();
    }

    if(op1 instanceof Float || op2 instanceof Float){
        return ((Number)op1).floatValue() + ((Number)op2).floatValue();
    }

    if(op1 instanceof Long || op2 instanceof Long){
        return ((Number)op1).longValue() + ((Number)op2).longValue();
    }

    return ((Number)op1).intValue() + ((Number)op2).intValue();
}
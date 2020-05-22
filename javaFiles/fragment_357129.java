public static void operationTo(double[] result, Operator op, double[] v1, double[] v2){
    int length = result.length;
    if(v1.length != length || v2.length != length) {
        throw new IllegalArgumentException("The dimension of the given lists are not the same.");
    }
    switch (op) { // use an enum
        case PLUS:
            for(int i = 0; i < length; i++) {
                result[i] = v1[i] + v2[i];
            }
        break;
        ...
    }
}
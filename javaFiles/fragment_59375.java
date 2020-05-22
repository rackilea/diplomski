public static final void main(String[] args){
    for(long i=Double.doubleToLongBits(1.0d); i<Long.MAX_VALUE; i++){
        double d = Double.longBitsToDouble(i);
        if(0.0d != (1.0d/d)*d - 1.0d){
            System.out.println(d);
        }
    }
}
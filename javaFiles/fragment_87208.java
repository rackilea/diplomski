if(value >= Byte.MIN_VALUE && value <= Byte.MAX_VALUE){
    // It's an integer than can fit inside a byte
}else if(value >= Short.MIN_VALUE && value <= Short.MAX_VALUE){
    // It's an integer than can fit inside a short
}else if(value >= Integer.MIN_VALUE && value <= Integer.MAX_VALUE){
    // It's an integer than can fit inside 32-bits
}else{
    // It's an integer than can fit inside 64-bits
}
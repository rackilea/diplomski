public static boolean isValidElement(String token) {
    int a1 = 214;
    if(a1 >= 0 && a1 <= 255){
        System.out.println(true); 
        return true;
    } else {
        System.out.println(false);  
        return false;
    }
}
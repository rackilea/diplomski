public static void main(String [] args){

    **long** number = 98;        
    **long** result = number;        
    int exponentt = 5;
    int exponent = exponentt--;     
    System.out.println(Math.pow(number, exponent));
    for (int i = 0; i < exponentt ;i++) {
        result = result * number;
        System.out.println(result );            
    }
}
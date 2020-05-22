public static void main(String[] args) {
             xMethod(5);
}

public static void xMethod(int length) { 

     System.out.println("Method Start "+ length);
        while (length > 1) {

            System.out.println("Inside while "+ length);

             xMethod(length - 1);
        }
        System.out.println("Method End "+ length);                 
    }
}
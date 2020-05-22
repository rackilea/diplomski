public static int wordOrder(int order, String result1, String result2){
        order = result1.compareToIgnoreCase(result2);
        if (order == 0){
            System.out.println("The words are the same.");
        }else if (order > 0){
            System.out.println("The order of the words alphabetically is " +result2+ " then " +result1+ ".");
        }else{
            System.out.println("The order of the words alphabetically is " +result1+ " then " +result2+  ".");
        }
        return order;
    }
static  String[] array=new String[]{"1","2"};

    public static void main(String[] args) {
        String[] array2=Arrays.copyOf(array, array.length);
       System.out.println("Printing array2:-");
        for(String elem:array2){
            System.out.print(elem+"|");
        }
        System.out.println("\nPrinting array:-");
        array[0]="4";
        for(String elem:array){
            System.out.print(elem+"|");
        }
        System.out.println("\nPrinting array2:-");
        for(String elem:array2){
            System.out.print(elem+"|");
        }
    }

Output:-

Printing array2:-
1|2|
Printing array:-
4|2|
Printing array2:-
1|2|
public static void main(String a[]){
        int count = 0;
        for (int i = 0; i<=255; i++){
            if(count == 10){
                System.out.println("Press \"ENTER\" to continue...");
                Scanner scanner = new Scanner(System.in);
                scanner.nextLine();
                count = 0;
            }else{
                System.out.printf("%d\t%c\n",i,i);
                count++;
            }


        }
    }
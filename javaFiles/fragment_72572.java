public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int[] occurrrences = new int[51];

        while (true){
            int value = scanner.nextInt();
            if(value>=0 && value<occurrrences.length){
                occurrrences[value]++;
            }else{
                scanner.close();
                break;
            }
        }
        for (int i = 0; i < occurrrences.length; i++) {
            if(occurrrences[i]>0){
                System.out.println(i + " occured " + occurrrences[i] + " times.");
            }
        }
    }
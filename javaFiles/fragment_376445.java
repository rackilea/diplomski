Scanner sc = new Scanner(System.in);
Random rnd= new Random();

System.out.println("How many array?:");
int[][] array = new int[sc.nextInt()][];
for(int j = 0; j < array.length; j++){
    System.out.println("Define array size:");
    array[j] = new int[sc.nextInt()];
    for(int i = 0; i < array[j].length; i++){
        array[j][i] = rnd.nextInt(1000000);
    }
    System.out.println(Arrays.toString(array[j]));
}
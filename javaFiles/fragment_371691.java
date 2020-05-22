String numbers = "12 1 890 65";
int[] ary = new int[4];

int i = 0;
Scanner sc = new Scanner(numbers);
while(sc.hasNextInt()){
    ary[i++] = sc.nextInt();
}
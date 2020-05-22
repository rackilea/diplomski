Scanner a = new Scanner(System.in);
try {
    num=a.nextInt();
} catch (InputMismatchException e) {
    System.out.println("Please only enter an integer"); 
} finally {
    num=a.nextInt();
}
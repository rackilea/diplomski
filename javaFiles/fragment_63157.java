System.out.println("Enter A word");
Scanner scan = new Scanner(System.in);
int a = 0;

String word = scan.nextLine();

while(a < word.length){
    System.out.println(word.charAt(a));
    a++;
}
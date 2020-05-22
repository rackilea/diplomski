ask = 1;
while(ask == 1)
{
    System.out.println("What is your phrase?");
    phrase = sc.nextLine();
    System.out.println("What is your additive key?");
    key = sc.nextInt();
    String code = addit(phrase, key);
    System.out.println(code);
    System.out.println("Enter 1 to go again");
    ask = sc.nextInt();
    String tmp = sc.nextLine();
}
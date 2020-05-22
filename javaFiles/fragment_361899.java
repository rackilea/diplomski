Scanner sc = new Scanner(System.in);

double num, answer=0;
int what, numOfNums, keepGoing = 1;

while (keepGoing == 1) {

    System.out.println("Enter a number: ");
    num = sc.nextDouble();

    System.out.println("1=Add; 2=Subtract; 3=Multiply; 4=Divide; 5=Answer");
    what = sc.nextInt();

    switch(what) {
      case 1:
      answer += num;
      break;

      case 2:
      answer -= num;
      break;

      case 3:
      answer *= num;
      break;

      case 4:
      answer /= num;
      break
    }

    if(what == 5) {
      keepGoing = 2;
      System.out.println(answer);
    }
}
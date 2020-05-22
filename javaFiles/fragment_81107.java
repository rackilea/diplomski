Scanner In = new Scanner(System.in);
int number = In.nextInt();
int index = 1;
int newNum;
String message = "";
Set<Integer> numbersSeen = new HashSet<Integer>();

while(true)
{
    newNum = number*index;
    message += "N ="+number*index+".  Now he has seen the digits ";
    while(newNum > 0) {
        numbersSeen.add(newNum % 10);
        newNum /= 10;
    }
    for(Integer seenNum : numbersSeen) {
        message += seenNum +", ";
    }
    System.out.println(message.substring(0,message.length()-2));
    message = "";
    index +=2;
    if(numbersSeen.size() == 10) {
        break;
    }
}
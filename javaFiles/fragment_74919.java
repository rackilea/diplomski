int ch;

public MyThread(int choice)
{
    ch = choice;
}

@Override
public void run() {
    // TODO Auto-generated method stub

    switch(ch)
    {
    case 1:
        doSomethingElse();          
        break;

    case 2:
        doYetAnotherThing();
        break;

    default:
        System.out.println("Illegal Choice");
        break;
    }

}

private static void doYetAnotherThing() {
    // TODO Auto-generated method stub
    System.out.println("Hi Agn");

}

private static void doSomethingElse() {
    // TODO Auto-generated method stub
    System.out.println("Hi");
    int i = 1;
    while(true)
    {
        System.out.println(i++);
    }
}
}